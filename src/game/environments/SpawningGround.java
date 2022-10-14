package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;

import java.util.List;

public abstract class SpawningGround extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    public int checkSurrounding(Location location, Element element){
        List<Exit> exits = location.getExits();
        int Count = 0;
        for(Exit exit: exits){
            Location exitLocation = exit.getDestination();
            if(exitLocation.getGround().hasCapability(element)){
                Count += 1;
            }
        }
        return Count;
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
