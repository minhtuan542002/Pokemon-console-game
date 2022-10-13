package game.specialattacks;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Special attack for Bulbasaur
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class VineWhip extends WeaponItem {
    /**
     * Constructor
     */
    public VineWhip() {
        super("Vine Whip", 's', 30, "whips", 70);
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
    }
}
