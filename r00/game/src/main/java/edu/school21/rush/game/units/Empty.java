package edu.school21.rush.game.units;

import edu.school21.rush.chaselogic.LogicEmpty;
import edu.school21.rush.game.Position;

public class Empty implements Unit, LogicEmpty {

    private UnitParameter unitParameter;

    public Empty(UnitParameter unitParameter) {
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
