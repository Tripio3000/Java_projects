package edu.school21.rush.chaselogic;

public class LogicPosition {
    protected int x = -1;

    protected int y = -1;

    public LogicPosition() {
    }

    public LogicPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
