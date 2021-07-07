package edu.school21.rush.game.utils;

import java.io.*;

import com.diogonunes.jcolor.Attribute;

public class Config {

    private Attribute playerColor;
    private char playerChar;

    private Attribute enemyColor;
    private char enemyChar;

    private Attribute wallColor;
    private char wallChar;

    private Attribute emptyColor;
    private char emptyChar;

    private Attribute targetColor;
    private char targetChar;

    private int mapGenerateCount = 1000;

    private boolean mapGenerateCountShow = false;

    private boolean screenUpdate = true;

    private boolean enemyComment = false;

    public Config(Args args) {
        playerColor = Utils.parseColorBack("LIME");
        enemyColor = Utils.parseColorBack("RED");
        wallColor = Utils.parseColorBack("PURPLE");
        emptyColor = Utils.parseColorBack("OLIVE");
        targetColor = Utils.parseColorBack("BLUE");

        playerChar = 'o';
        enemyChar = 'X';
        wallChar = '#';
        emptyChar = ' ';
        targetChar = 'O';

        try {
            parseConfig(args);
        } catch (IOException e) {
            throw new IllegalParametersException("");
        }
    }

    private void parseConfig(Args args) throws IOException {

      InputStream inputStream = Config.class.getClassLoader().
              getResourceAsStream("application-production.properties");

        switch (args.getProfile()){
            case CUSTOM:
                inputStream = Config.class.getClassLoader().
                        getResourceAsStream(args.profileValue + ".properties");
                break;
            case DEVELOPMENT:
                inputStream = Config.class.getClassLoader().
                        getResourceAsStream("application-dev.properties");
                break;
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] parse = line.split(" = ");
            if (parse.length == 2 && parse[1].length() > 1) {
                switch (parse[0]) {
                    case "enemy.char":
                        enemyChar = parse[1].toCharArray()[0];
                        break;
                    case "player.char":
                        playerChar = parse[1].toCharArray()[0];
                        break;
                    case "wall.char":
                        wallChar = parse[1].toCharArray()[0];
                        break;
                    case "goal.char":
                        targetChar = parse[1].toCharArray()[0];
                        break;
                    case "empty.char":
                        emptyChar = parse[1].toCharArray()[0];
                        break;
                    case "enemy.color":
                        enemyColor = Utils.parseColorBack(parse[1]);
                        break;
                    case "player.color":
                        playerColor = Utils.parseColorBack(parse[1]);
                        break;
                    case "wall.color":
                        wallColor = Utils.parseColorBack(parse[1]);
                        break;
                    case "goal.color":
                        targetColor = Utils.parseColorBack(parse[1]);
                        break;
                    case "empty.color":
                        emptyColor = Utils.parseColorBack(parse[1]);
                        break;
                    case "map.generate.count":
                        try {
                            int count = Integer.getInteger(parse[1]);

                            if (count > 0) {
                                mapGenerateCount = count;
                            }
                        } catch (Exception ignored){

                        }
                        break;
                    case "map.generate.count.show":
                        if (parse[1].equals("true")){
                            mapGenerateCountShow = true;
                        } else if (parse[1].equals("false")){
                            mapGenerateCountShow = false;
                        }
                        break;
                    case "screen.update":
                        if (parse[1].equals("true")){
                            screenUpdate = true;
                        } else if (parse[1].equals("false")){
                            screenUpdate = false;
                        }
                        break;
                    case "enemy.comment":
                        if (parse[1].equals("true")){
                            enemyComment = true;
                        } else if (parse[1].equals("false")){
                            enemyComment = false;
                        }
                        break;
                }
            }
        }

        bufferedReader.close();
    }

    public Attribute getPlayerColor() {
        return playerColor;
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public Attribute getEnemyColor() {
        return enemyColor;
    }

    public char getEnemyChar() {
        return enemyChar;
    }

    public Attribute getWallColor() {
        return wallColor;
    }

    public char getWallChar() {
        return wallChar;
    }

    public Attribute getEmptyColor() {
        return emptyColor;
    }

    public char getEmptyChar() {
        return emptyChar;
    }

    public Attribute getTargetColor() {
        return targetColor;
    }

    public char getTargetChar() {
        return targetChar;
    }

    public int getMapGenerateCount() {
        return mapGenerateCount;
    }

    public boolean isScreenUpdate() {
        return screenUpdate;
    }

    public boolean isEnemyComment() {
        return enemyComment;
    }

    public boolean isMapGenerateCountShow() {
        return mapGenerateCountShow;
    }
}
