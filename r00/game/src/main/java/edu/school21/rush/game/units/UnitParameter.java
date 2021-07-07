package edu.school21.rush.game.units;

import com.diogonunes.jcolor.Attribute;
import edu.school21.rush.game.Position;

public class UnitParameter {

    private Attribute color;

    private char unitChar;

    private Position position;


    public UnitParameter(Attribute color, char unitChar, Position position) {
        this.color = color;
        this.unitChar = unitChar;
        this.position = position;
    }

    public UnitParameter(Attribute color, char unitChar) {
        this.color = color;
        this.unitChar = unitChar;
        this.position = new Position(-1, -1);
    }

    public Attribute getColor() {
        return color;
    }

    public void setColor(Attribute color) {
        this.color = color;
    }

    public char getUnitChar() {
        return unitChar;
    }

    public void setUnitChar(char unitChar) {
        this.unitChar = unitChar;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
