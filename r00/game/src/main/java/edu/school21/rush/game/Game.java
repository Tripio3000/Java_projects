package edu.school21.rush.game;

import java.util.List;
import java.util.Scanner;

import com.beust.jcommander.JCommander;
import edu.school21.rush.chaselogic.EnemyLogic;
import edu.school21.rush.chaselogic.LogicPosition;
import edu.school21.rush.game.units.Enemy;
import edu.school21.rush.game.units.MoveableUnit;
import edu.school21.rush.game.utils.Args;
import edu.school21.rush.game.utils.IllegalParametersException;
import edu.school21.rush.game.utils.Keyboard;

public class Game {

    private GameMap gameMap;

    private GameParameters gameParameters;

    private Scanner scanner;

    public static void main(String[] argv) {
        Game game = new Game();

        try {
            Args args = new Args();

            JCommander.newBuilder().addObject(args).build().parse(argv);
            game.start(args);
        } catch (Exception e) {
            System.err.println("IllegalParametersException. Launch options incorrect. Start the game with the correct data." +
                    "\nex: --enemiesCount=3 --wallsCount=20 --size=15 --profile=dev");
            System.exit(-1);
        }
    }

    private void start(Args args) {
        scanner = new Scanner(System.in);

        gameParameters = new GameParameters(args);

        try {
            gameMap = new GameMap(gameParameters);
        } catch (IllegalParametersException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

        gameMap.drawFrame();

        loop();
    }

    private void loop() {

        GameMap.GameState gameState = GameMap.GameState.READY_NEXT;

        while (gameState != GameMap.GameState.PLAYER_WIN &&
                gameState != GameMap.GameState.PLAYER_LOSE && gameMap.isHasMove()) {

            Keyboard.Key key = Keyboard.getKeyByInput(scanner.next());

            switch (key) {
                case W:
                    gameState = gameMap.move(gameMap.getPlayer(), MoveableUnit.Direction.W);
                    break;
                case A:
                    gameState = gameMap.move(gameMap.getPlayer(), MoveableUnit.Direction.A);
                    break;
                case D:
                    gameState = gameMap.move(gameMap.getPlayer(), MoveableUnit.Direction.D);
                    break;
                case S:
                    gameState = gameMap.move(gameMap.getPlayer(), MoveableUnit.Direction.S);
                    break;
                case FORCE_STOP:
                    gameState = GameMap.GameState.PLAYER_LOSE;
                    break;
                default:
                    gameState = GameMap.GameState.REPEAT;
            }

            gameMap.drawFrame();
            if (gameState == GameMap.GameState.READY_NEXT) {
                gameState = getEnemyMove(gameMap);
            } else if (gameState == GameMap.GameState.REPEAT) {
                System.out.println("Movement key\n" +
                        "WASD - direction\n9 - stop game\n8 - confirm(dev mode)");
            }
        }

        if (gameState == GameMap.GameState.PLAYER_WIN) {
            System.out.println("You win!!! Congratulations!!");
        } else {
            System.out.println("GAME OVER!!!");
        }
    }

    private GameMap.GameState getEnemyMove(GameMap gameMap) {
        EnemyLogic logic = new EnemyLogic(gameMap);

        GameMap.GameState gameState = GameMap.GameState.READY_NEXT;
        List<Enemy> enemies = gameMap.getEnemiess();

        for (Enemy enemy : enemies) {
            if (gameParameters.getProfile() == Args.Profile.DEVELOPMENT) {
                System.out.println("Input 8 to confirm");
                while (scanner.hasNext() && !scanner.next().equals("8")) {
                    System.out.println("Input 8 to confirm");
                }
            }
            LogicPosition newPosition = logic.getMove(enemy);
            Position currentPosition = enemy.getPosition();
            if (newPosition != null) {
                MoveableUnit.Direction direction = getDirection(enemy.getPosition(), newPosition);
                if (direction != null) {
                    gameState = gameMap.move(enemy, direction);
                    gameMap.drawFrame();
                    if (gameParameters.isEnemyComment()) {
                        sendMsg(enemy.getId(), currentPosition, newPosition);
                    }
                }
            }
            if (gameState != GameMap.GameState.READY_NEXT)
                break;
        }

        return gameState;
    }

    private void sendMsg(int id, Position currentPosition, LogicPosition newPosition) {
        System.out.println("Enemy " + id +
                ": [" + currentPosition.getX() + ":" + currentPosition.getY() + "] => [" +
                newPosition.getX() + ":" + newPosition.getY() + "]");
    }

    MoveableUnit.Direction getDirection(Position currentPosition, LogicPosition nextPosition) {
        if (nextPosition.getX() > currentPosition.getX()) {
            return MoveableUnit.Direction.D;
        }

        if (nextPosition.getX() < currentPosition.getX()) {
            return MoveableUnit.Direction.A;
        }

        if (nextPosition.getY() < currentPosition.getY()) {
            return MoveableUnit.Direction.W;
        }

        if (nextPosition.getY() > currentPosition.getY()) {
            return MoveableUnit.Direction.S;
        }

        return null;
    }


}
