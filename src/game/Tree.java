package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

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
    public void spawnPokemon(Location location) {

    }

    @Override
    public void dropPokeFruit() {

    }


}
