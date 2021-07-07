package edu.school21.rush.game.utils;

public class EnemyIdsGenerator {

    private int globalId = 1;

    private static EnemyIdsGenerator instance;

    private EnemyIdsGenerator() {
    }

    public static EnemyIdsGenerator getInstance(){
        if (instance == null) {
            instance = new EnemyIdsGenerator();
        }

        return instance;
    }

    public int generateId(){
        return globalId++;
    }
}
