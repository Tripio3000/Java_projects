package edu.school21.rush.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import edu.school21.rush.chaselogic.LogicEnemy;
import edu.school21.rush.chaselogic.LogicGameMap;
import edu.school21.rush.chaselogic.LogicPlayer;
import edu.school21.rush.chaselogic.UnitLogic;
import edu.school21.rush.game.units.*;
import edu.school21.rush.game.utils.Args;
import edu.school21.rush.game.utils.IllegalParametersException;

public class GameMap implements LogicGameMap {

    enum GameState {
        PLAYER_WIN, PLAYER_LOSE, READY_NEXT, COLLISION, OUT_OF_MAP, REPEAT
    }

    private final GameParameters gameParameters;

    private Unit[][] map;

    private Player player;

    public GameMap(GameParameters gameParameters) {
        this.gameParameters = gameParameters;
        valid(gameParameters);

        map = new Unit[gameParameters.getLengthSide()][gameParameters.getLengthSide()];

        generateRandomUnits();

        int tryId = 1;
        while (!isSolvable() && tryId < gameParameters.getCountGenerateAttempt()){
            tryId++;
            rebuildMap();
        }
        if (!isSolvable()){
            throw new IllegalParametersException("IllegalParametersException. " +
                    "Unable to generate a valid map with the current parameters. Try 100/100");
        }
        if (gameParameters.isMapGenerateCountShow()) {
            System.out.println("Generated on " + tryId + " attempts");
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    public void drawFrame() {
        if (gameParameters.getProfile() != Args.Profile.DEVELOPMENT && gameParameters.isScreenUpdate()) {
            try {
                clearConsole();
            } catch (Exception ignored) {

            }
        }

        for (int h = 0; h < gameParameters.getLengthSide(); h++) {
            for (int w = 0; w < gameParameters.getLengthSide(); w++) {
                Attribute bgColor = map[h][w].getParameter().getColor();
                System.out.print(Ansi.colorize(" " + map[h][w].getParameter().getUnitChar() + " ",
                        bgColor, Attribute.BLACK_TEXT(), Attribute.BOLD()));
            }
            System.out.println();
        }
    }

    private void addWall() {
        int h = -1;
        int w = -1;

        Random random = new Random();

        while (h < 0) {
            h = random.nextInt(gameParameters.getLengthSide());
            w = random.nextInt(gameParameters.getLengthSide());
            if (map[h][w] == null) {
                Wall wall = new Wall(new UnitParameter(gameParameters.getWallColor(),
                        gameParameters.getWallChar(), new Position(w, h)));
                map[h][w] = wall;
            } else {
                h = -1;
            }
        }
    }

    private void generateRandomUnits() {

        for (int i = 0; i < gameParameters.getWallCount(); i++) {
            addWall();
        }

        Position targetPosition = addTargetPosition();

        addPlayer(targetPosition);

        for (int i = 0; i < gameParameters.getEnemyCount(); i++) {
            addEnemy();
        }

        addEmpty();
    }

    public void rebuildMap(){
        map = new Unit[gameParameters.getLengthSide()][gameParameters.getLengthSide()];
        generateRandomUnits();
    }

    private void addEmpty() {
        for (int h = 0; h < gameParameters.getLengthSide(); h++) {
            for (int w = 0; w < gameParameters.getLengthSide(); w++) {
                if (map[h][w] == null) {
                    Empty empty = new Empty(new UnitParameter(gameParameters.getEmptyColor(),
                            gameParameters.getEmptyChar(), new Position(w, h)));
                    map[h][w] = empty;
                }
            }
        }
    }

    private void addEnemy() {
        int h = -1;
        int w = -1;

        Random random = new Random();

        while (h < 0) {
            h = random.nextInt(gameParameters.getLengthSide());
            w = random.nextInt(gameParameters.getLengthSide());
            if (map[h][w] == null) {
                Enemy enemy = new Enemy(new UnitParameter(gameParameters.getEnemyColor(),
                        gameParameters.getEnemyChar(), new Position(w, h)));
                map[h][w] = enemy;
            } else {
                h = -1;
            }
        }
    }

    private Position addTargetPosition() {
        int h;
        int w;

        Random random = new Random();

        while (true) {
            h = random.nextInt(gameParameters.getLengthSide());
            w = random.nextInt(gameParameters.getLengthSide());
            if (map[h][w] == null) {
                Target target = new Target(new UnitParameter(gameParameters.getTargetColor(),
                        gameParameters.getTargetChar(), new Position(w, h)));
                map[h][w] = target;
                return new Position(w, h);
            }
        }
    }

    private Position addPlayer(Position targetPosition) {
        int h = -1;
        int w = -1;

        Random random = new Random();

        while (h < 0) {
            h = random.nextInt(gameParameters.getLengthSide());
            w = random.nextInt(gameParameters.getLengthSide());
            if (map[h][w] == null) {
                player = new Player(new UnitParameter(gameParameters.getPlayerColor(),
                        gameParameters.getPlayerChar(), new Position(w, h)), targetPosition);
                map[h][w] = player;
                return new Position(w, h);
            } else {
                h = -1;
            }
        }
        return null;
    }

    private void valid(GameParameters gameParameters) {

        if (gameParameters.getLengthSide() > 500){
            throw new IllegalParametersException("IllegalParametersException. Max size = 500");
        }

        int maxUnit = gameParameters.getLengthSide() * gameParameters.getLengthSide();

        int currentUnit = gameParameters.getEnemyCount() + gameParameters.getWallCount() + 2;
        if (gameParameters.getLengthSide() < 1 || gameParameters.getEnemyCount() < 1 ||
                gameParameters.getWallCount() < 1 || gameParameters.getCountGenerateAttempt() <= 0) {
            throw new IllegalParametersException("IllegalParametersException." +
                    " Launch options incorrect. Start the game with the correct data." +
                    "\nex: --enemiesCount=3 --wallsCount=20 --size=15 [ --profile=dev ] ");
        }

        if (currentUnit >= maxUnit){
            throw new IllegalParametersException("IllegalParametersException. " +
                    "The number of units is greater than the " +
                    "place on the map. Start the game with the correct data");
        }
    }

    public boolean isEmptyPosition(Position position) {
        return (map[position.getY()][position.getX()] instanceof Empty);
    }

    public boolean isTargetPosition(Position position) {
        return (map[position.getY()][position.getX()] instanceof Target);
    }

    public boolean isPlayerPosition(Position position) {
        return (map[position.getY()][position.getX()] instanceof Player);
    }

    public Unit[][] getMap() {
        return map;
    }

    @Override
    public UnitLogic[][] getMapLogic() {
        return map;
    }

    public void move(Position unitPosition, Position emptyPosition) {
        MoveableUnit unit = (MoveableUnit) (map[unitPosition.getY()][unitPosition.getX()]);
        Empty empty = new Empty(new UnitParameter(gameParameters.getEmptyColor(),
                gameParameters.getEmptyChar(), unitPosition));

        map[emptyPosition.getY()][emptyPosition.getX()] = unit;
        unit.setPosition(emptyPosition);
        map[unitPosition.getY()][unitPosition.getX()] = empty;
    }

    public Player getPlayer() {
        return player;
    }


    @Override
    public LogicPlayer getPlayerLogic() {
        return player;
    }



    public boolean isHasMove() {
        Position position = player.getPosition();

        if (position.getX() > 0 && (map[position.getY()][position.getX() - 1] instanceof Empty ||
                position.getX() > 0 && map[position.getY()][position.getX() - 1] instanceof Target)) {
            return true;
        }

        if (position.getX() < gameParameters.getLengthSide() - 1 &&
                (map[position.getY()][position.getX() + 1] instanceof Empty ||
                        map[position.getY()][position.getX() + 1] instanceof Target)) {
            return true;
        }

        if (position.getY() > 0 && (map[position.getY() - 1][position.getX()] instanceof Empty
                || map[position.getY() - 1][position.getX()] instanceof Target)) {
            return true;
        }

        if (position.getY() < gameParameters.getLengthSide() - 1 &&
                (map[position.getY() + 1][position.getX()] instanceof Empty ||
                        map[position.getY() + 1][position.getX()] instanceof Target)) {
            return true;
        }

        return false;
    }

    public GameState move(MoveableUnit unit, MoveableUnit.Direction direction) {
        int newY = unit.getPosition().getY();
        int newX = unit.getPosition().getX();

        switch (direction) {
            case W:
                newY = unit.getPosition().getY() - 1;
                break;
            case A:
                newX = unit.getPosition().getX() - 1;
                break;
            case S:
                newY = unit.getPosition().getY() + 1;
                break;
            case D:
                newX = unit.getPosition().getX() + 1;
                break;
        }
        if ((newY >= 0 && newY < gameParameters.getLengthSide()) &&
                (newX >= 0 && newX < gameParameters.getLengthSide())) {
            Position newPosition = new Position(newX, newY);
            if (isEmptyPosition(newPosition)) {
                move(unit.getPosition(), newPosition);
                return GameState.READY_NEXT;
            } else if (unit instanceof Player && isTargetPosition(newPosition)) {
                move(unit.getPosition(), newPosition);
                return GameState.PLAYER_WIN;
            } else if (unit instanceof Enemy && isPlayerPosition(newPosition)) {
                return GameState.PLAYER_LOSE;
            } else {
                return GameState.OUT_OF_MAP;
            }
        } else {
            return GameState.COLLISION;
        }
    }

    @Override
    public List<LogicEnemy> getEnemiesLogic() {
        List<LogicEnemy> list = new ArrayList<>();

        for (int h = 0; h < gameParameters.getLengthSide(); h++) {
            for (int w = 0; w < gameParameters.getLengthSide(); w++) {
                if (map[h][w] instanceof Enemy) {
                    list.add((Enemy) map[h][w]);
                }
            }
        }

        return list;
    }

    public List<Enemy> getEnemiess() {
        List<Enemy> list = new ArrayList<>();

        for (int h = 0; h < gameParameters.getLengthSide(); h++) {
            for (int w = 0; w < gameParameters.getLengthSide(); w++) {
                if (map[h][w] instanceof Enemy) {
                    list.add((Enemy) map[h][w]);
                }
            }
        }

        return list;
    }

    public boolean isSolvable() {

        int x = player.getPosition().getX();
        int y = player.getPosition().getY();

        Integer[][] mapFlags = new Integer[gameParameters.getLengthSide()][gameParameters.getLengthSide()];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        Position next;
        while (!queue.isEmpty()) {
            next = queue.poll();
            x = next.getX();
            y = next.getY();

            if (map[y][x] instanceof Target) {
                return true;
            }

            if (x + 1 < gameParameters.getLengthSide() &&
                    (map[y][x + 1] instanceof Empty ||  map[y][x + 1] instanceof Target )
            && mapFlags[y][x + 1] == null) {
                queue.add(new Position(x + 1, y));
                mapFlags[y][x + 1] = 1;
            }
            if (x - 1 >= 0 &&
                    (map[y][x - 1] instanceof Empty || map[y][x - 1] instanceof Target )
                    && mapFlags[y][x - 1] == null) {
                queue.add(new Position(x - 1, y));
                mapFlags[y][x - 1] = 1;
            }
            if (y + 1 < gameParameters.getLengthSide() && (
                    map[y + 1][x] instanceof Empty || map[y + 1][x] instanceof Target )
                    && mapFlags[y + 1][x] == null) {
                queue.add(new Position(x, y + 1));
                mapFlags[y + 1][x] = 1;
            }
            if (y - 1 >= 0 &&
                    (map[y - 1][x] instanceof Empty || map[y - 1][x] instanceof Target )
                    && mapFlags[y - 1][x] == null) {
                queue.add(new Position(x, y - 1));
                mapFlags[y - 1][x] = 1;
            }
        }
        return false;
    }

    public GameParameters getGameParameters() {
        return gameParameters;
    }
}
