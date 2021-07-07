package edu.school21.rush.game.units;

import edu.school21.rush.game.Position;

public class Wall implements Unit{

    private UnitParameter unitParameter;

    public Wall(UnitParameter unitParameter) {
        this.unitParameter = unitParameter;
    }

    @Override
    public Position getPosition() {
        return unitParameter.getPosition();
    }

    @Override
    public UnitParameter getParameter() {
        return unitParameter;
    }
}
