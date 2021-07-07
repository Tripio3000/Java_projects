package edu.school21.rush.game.units;

import edu.school21.rush.chaselogic.UnitLogic;
import edu.school21.rush.game.Position;

public interface Unit extends UnitLogic {

    Position getPosition();

    UnitParameter getParameter();


}
