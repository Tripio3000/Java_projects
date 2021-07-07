package edu.school21.rush.game.units;

import edu.school21.rush.chaselogic.LogicPlayer;
import edu.school21.rush.chaselogic.LogicPosition;
import edu.school21.rush.game.Position;

public class Player extends LogicPlayer implements MoveableUnit {

    private UnitParameter unitParameter;

    private Position targetPosition;

    public Player(UnitParameter unitParameter, Position targetPosition) {
        this.unitParameter = unitParameter;
        this.targetPosition = targetPosition;
    }

    @Override
    public Position getPosition() {
        return unitParameter.getPosition();
    }

    @Override
    public UnitParameter getParameter() {
        return unitParameter;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }

    @Override
    public void setPosition(LogicPosition position) {
        unitParameter.setPosition((Position) position);
    }

    @Override
    public void setPosition(Position position) {
        unitParameter.setPosition(position);
    }
}
