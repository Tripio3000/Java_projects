package edu.school21.rush.chaselogic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EnemyLogic {

    UnitLogic[][] map;
    List<LogicEnemy> enemies;
    LogicPlayer player;
    LogicPosition targetPos;

    public EnemyLogic(LogicGameMap gameMap) {
        map = gameMap.getMapLogic();
        enemies = gameMap.getEnemiesLogic();
        player = gameMap.getPlayerLogic();
        targetPos = player.getTargetPosition();
    }

    public LogicPosition getMove(LogicEnemy enemy) {
        Integer[][] algoMaps = new Integer[map.length][map.length];
        int x = enemy.getPosition().getX();
        int y = enemy.getPosition().getY();
        int visit = 1;
        Queue<LogicPosition> queue = new LinkedList<>();
        queue.add(new LogicPosition(x, y));
        algoMaps[y][x] = 0;
        LogicPosition next;
        while (!queue.isEmpty()) {
            next = queue.poll();
            x = next.getX();
            y = next.getY();
            visit = algoMaps[y][x];
            if (x == player.getPosition().getX() && y == player.getPosition().getY()) {
                break;
            }
            if (x + 1 < map.length &&
                    (map[y][x + 1] instanceof LogicEmpty || map[y][x + 1] instanceof LogicPlayer) && algoMaps[y][x + 1] == null) {
                queue.add(new LogicPosition(x + 1, y));
                algoMaps[y][x + 1] = visit + 1;
            }
            if (x - 1 >= 0 &&
                    (map[y][x - 1] instanceof LogicEmpty || map[y][x - 1] instanceof LogicPlayer) && algoMaps[y][x - 1] == null) {
                queue.add(new LogicPosition(x - 1, y));
                algoMaps[y][x - 1] = visit + 1;
            }
            if (y + 1 < map.length && (
                    map[y + 1][x] instanceof LogicEmpty || map[y + 1][x] instanceof LogicPlayer) && algoMaps[y + 1][x] == null) {
                queue.add(new LogicPosition(x, y + 1));
                algoMaps[y + 1][x] = visit + 1;
            }
            if (y - 1 >= 0 &&
                    (map[y - 1][x] instanceof LogicEmpty || map[y - 1][x] instanceof LogicPlayer) && algoMaps[y - 1][x] == null) {
                queue.add(new LogicPosition(x, y - 1));
                algoMaps[y - 1][x] = visit + 1;
            }
        }
        return backMove(algoMaps, visit);
    }

    private LogicPosition backMove(Integer[][] algoMaps, Integer visit) {
        int x;
        int y;
        int moves = visit;
        Queue<LogicPosition> queue = new LinkedList<>();
        queue.add(new LogicPosition(player.getPosition().getX(), player.getPosition().getY()));
        while (!queue.isEmpty()) {
            LogicPosition next = queue.poll();
            x = next.getX();
            y = next.getY();
            if (algoMaps[y][x] == null) {
                return null;
            }
            if (algoMaps[y][x] == 1) {
                return new LogicPosition(x, y);
            }
            if (x + 1 < map.length && algoMaps[y][x + 1] != null && algoMaps[y][x + 1] == moves - 1) {
                queue.add(new LogicPosition(x + 1, y));
            } else if (x - 1 >= 0 && algoMaps[y][x - 1] != null && algoMaps[y][x - 1] == moves - 1) {
                queue.add(new LogicPosition(x - 1, y));
            } else if (y + 1 < map.length && algoMaps[y + 1][x] != null && algoMaps[y + 1][x] == moves - 1) {
                queue.add(new LogicPosition(x, y + 1));
            } else if (y - 1 >= 0 && algoMaps[y - 1][x] != null && algoMaps[y - 1][x] == moves - 1) {
                queue.add(new LogicPosition(x, y - 1));
            }
            moves--;
        }
        return null;
    }

}
