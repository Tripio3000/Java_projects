package edu.school21.rush.game.units;

import edu.school21.rush.game.Position;

public class Target implements Unit{

    private UnitParameter unitParameter;

    public Target(UnitParameter unitParameter) {
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
