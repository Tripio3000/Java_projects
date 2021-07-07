package edu.school21.rush.chaselogic;

import java.util.List;

public interface LogicGameMap {

     UnitLogic[][] getMapLogic();

     LogicPlayer getPlayerLogic();

     List<LogicEnemy> getEnemiesLogic();

}
