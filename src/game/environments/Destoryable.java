package game.environments;

import edu.monash.fit2099.engine.positions.Location;

public interface Destoryable {
    default void destory(Location location){
        boolean bool = location.containsAnActor();
        if(!bool){
            Dirt dirt = new Dirt();
            location.setGround(dirt);
        }
    }
}
