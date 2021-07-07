package edu.school21.rush.game.units;

public class EnemyRoute {

    private Enemy enemy;

    private MoveableUnit.Direction direction;

    public EnemyRoute(Enemy enemy, MoveableUnit.Direction direction) {
        this.enemy = enemy;
        this.direction = direction;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public MoveableUnit.Direction getDirection() {
        return direction;
    }
}
