package edu.school21.rush.game.utils;

import com.diogonunes.jcolor.Attribute;

public class Utils {

    public static Attribute parseColorBack(String color) {

        switch (color) {
            case "RED":
                return Attribute.BACK_COLOR(255, 0, 0);
            case "GREEN":
                return Attribute.BACK_COLOR(0, 128, 0);
            case "WHITE":
                return Attribute.BACK_COLOR(255, 255, 255);
            case "YELLOW":
                return Attribute.BACK_COLOR(255, 255, 0);
            case "LIME":
                return Attribute.BACK_COLOR(0, 255, 0);
            case "OLIVE":
                return Attribute.BACK_COLOR(128, 128, 0);
            case "NAVY":
                return Attribute.BACK_COLOR(0, 0, 128);
            case "BLUE":
                return Attribute.BACK_COLOR(0, 0, 255);
            case "AQUA":
                return Attribute.BACK_COLOR(0, 255, 255);
            case "FUCHSIA":
            case "MAGENTA":
                return Attribute.BACK_COLOR(255, 0, 255);
            case "PURPLE":
                return Attribute.BACK_COLOR(128, 0, 128);
            case "BLACK":
                return Attribute.BACK_COLOR(0, 0, 0);
            case "GRAY":
                return Attribute.BACK_COLOR(128, 128, 128);
            case "SILVER":
                return Attribute.BACK_COLOR(192, 192, 192);
            default:
                return Attribute.BACK_COLOR(255, 255, 255);
        }
    }

    public static Attribute parseColorText(String color) {
        switch (color) {
            case "RED":
                return Attribute.TEXT_COLOR(255, 0, 0);
            case "GREEN":
                return Attribute.TEXT_COLOR(0, 128, 0);
            case "WHITE":
                return Attribute.TEXT_COLOR(255, 255, 255);
            case "YELLOW":
                return Attribute.TEXT_COLOR(255, 255, 0);
            case "LIME":
                return Attribute.TEXT_COLOR(0, 255, 0);
            case "OLIVE":
                return Attribute.TEXT_COLOR(128, 128, 0);
            case "NAVY":
                return Attribute.TEXT_COLOR(0, 0, 128);
            case "BLUE":
                return Attribute.TEXT_COLOR(0, 0, 255);
            case "AQUA":
                return Attribute.TEXT_COLOR(0, 255, 255);
            case "FUCHSIA":
                return Attribute.TEXT_COLOR(255, 0, 255);
            case "PURPLE":
                return Attribute.TEXT_COLOR(128, 0, 128);
            case "BLACK":
                return Attribute.TEXT_COLOR(0, 0, 0);
            case "GRAY":
                return Attribute.TEXT_COLOR(128, 128, 128);
            case "SILVER":
                return Attribute.TEXT_COLOR(192, 192, 192);

            default:
                return Attribute.TEXT_COLOR(255, 255, 255);
        }
    }


}
