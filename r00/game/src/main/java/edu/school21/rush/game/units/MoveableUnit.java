package edu.school21.rush.game.units;

import edu.school21.rush.game.Position;

public interface MoveableUnit extends Unit {

    enum Direction{
        W,A,S,D
    }

    void setPosition(Position position);
}
