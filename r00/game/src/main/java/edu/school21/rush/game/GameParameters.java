package edu.school21.rush.game;

import edu.school21.rush.game.utils.Args;
import edu.school21.rush.game.utils.Config;

public class GameParameters extends Config {

    private Args args;

    public GameParameters(Args args) {
        super(args);
        this.args = args;
    }

    public int getEnemyCount() {
        return args.getEnemiesCount();
    }

    public int getWallCount() {
        return args.getWallsCount();
    }

    public int getLengthSide() {
        return args.getWallLen();
    }

    public int getCountGenerateAttempt() {
        return getMapGenerateCount();
    }

    public Args.Profile getProfile() {
        return args.getProfile();
    }

}
