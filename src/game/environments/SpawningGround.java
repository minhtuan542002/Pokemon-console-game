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
     */
    public abstract void spawnPokemon(Location location);

    public abstract void dropPokeFruit(Location location);

    public void tick(Location location) {
        //put in abstract class
        this.spawnPokemon(location);
        this.dropPokeFruit(location);
    }





}
