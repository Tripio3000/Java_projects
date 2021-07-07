package edu.school21.rush.game.units;

import edu.school21.rush.chaselogic.LogicEnemy;
import edu.school21.rush.chaselogic.LogicPosition;
import edu.school21.rush.game.Position;
import edu.school21.rush.game.utils.EnemyIdsGenerator;

public class Enemy extends LogicEnemy implements MoveableUnit{

    private UnitParameter unitParameter;

    private int id;

    public Enemy(UnitParameter unitParameter) {
        this.unitParameter = unitParameter;
        this.id = EnemyIdsGenerator.getInstance().generateId();
    }

    @Override
    public Position getPosition() {
        return unitParameter.getPosition();
    }

    @Override
    public void setPosition(LogicPosition position) {
        unitParameter.setPosition((Position) position);
    }

    @Override
    public UnitParameter getParameter() {
        return unitParameter;
    }

    @Override
    public void setPosition(Position position) {
        unitParameter.setPosition(position);
    }

    public int getId() {
        return id;
    }
}
