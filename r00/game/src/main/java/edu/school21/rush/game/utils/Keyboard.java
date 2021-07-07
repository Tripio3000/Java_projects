package edu.school21.rush.game.utils;

public class Keyboard {

    public enum Key {
        W, A, S, D, FORCE_STOP, DEV_CONFIRM, UNKNOWN
    }


    public static Key getKeyByInput(String s) {
        if (s == null)
            return Key.UNKNOWN;

        switch (s) {
            case "W":
            case "w":
            case "119":
                return Key.W;
            case "A":
            case "a":
            case "97":
                return Key.A;
            case "S":
            case "s":
            case "115":
                return Key.S;
            case "D":
            case "d":
            case "100":
                return Key.D;
            case "8":
            case "56":
                return Key.DEV_CONFIRM;
            case "9":
            case "57":
                return Key.FORCE_STOP;
            default:
                return Key.UNKNOWN;
        }
    }
}
