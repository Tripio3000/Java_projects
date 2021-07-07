package edu.school21.rush.game.utils;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args {

    public enum Profile {
        PRODUCTION, DEVELOPMENT, CUSTOM
    }

    @Parameter(names = "--enemiesCount")
    int enemiesCount = 3;

    @Parameter(names = "--wallsCount")
    int wallsCount = 10;

    @Parameter(names = "--size")
    int wallLen = 15;

    @Parameter(names = "--profile")
    protected String profileValue = "production";

    public int getEnemiesCount() {
        return enemiesCount;
    }

    public int getWallsCount() {
        return wallsCount;
    }

    public int getWallLen() {
        return wallLen;
    }

    public Profile getProfile() {
        switch (profileValue){
            case "production":
                return Profile.PRODUCTION;
            case "dev":
                return Profile.DEVELOPMENT;
            default:
                return Profile.CUSTOM;
        }
    }

}
