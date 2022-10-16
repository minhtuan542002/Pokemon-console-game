package game.environments;

import edu.monash.fit2099.engine.positions.Location;

public interface Destoryable {
/**
 * a default method that destory the ground to dirt
 * @param location Location of the ground
 */
    default void destory(Location location){
        boolean bool = location.containsAnActor();
        if(!bool){
            Dirt dirt = new Dirt();
            location.setGround(dirt);
        }
    }
}
