package game;

import edu.monash.fit2099.engine.positions.Ground;

public class Tree extends SpawningGround {

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
    }

    @Override
    public String getSpawningGround() {
        return null;
    }

    @Override
    public int chanceToSpawn() {
        return 0;
    }
}
