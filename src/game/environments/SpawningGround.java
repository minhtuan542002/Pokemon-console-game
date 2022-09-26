package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

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

     * spawn pokemon on that ground location
     *
     * @param location the location of that ground
     */
    public abstract void spawnPokemon(Location location);

    /**
     * TODO: override this method.

     * drop pokefruit on that ground location
     *
     * @param location the location of that ground
     */
    public abstract void dropPokeFruit(Location location);

    @Override
    public void tick(Location location) {
        this.spawnPokemon(location);
        this.dropPokeFruit(location);
    }
}
