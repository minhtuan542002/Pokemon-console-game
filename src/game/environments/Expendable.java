package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

public interface Expendable {
    default void expend(Location location, Ground ground) {
        List<Exit> exits = location.getExits();
        for (Exit exit : exits) {
            Location exitLocation = exit.getDestination();
            exitLocation.setGround(ground);
        }
    }
}

