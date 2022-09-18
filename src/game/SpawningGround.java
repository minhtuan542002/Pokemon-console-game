package game;

import edu.monash.fit2099.engine.positions.Ground;

public abstract class SpawningGround extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    /**
     * TODO: override this method.
     */
    public abstract String getSpawningGround();

    /**
     * TODO: override this method.
     */
    public abstract void spawnPokemon();

    public abstract void dropPokeFruit();

    public abstract void tick();

}
