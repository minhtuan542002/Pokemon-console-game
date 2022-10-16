package game.specialattacks;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Special attack for Charizard
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class FireSpin extends WeaponItem {
    /**
     * Constructor.
     *
     */
    public FireSpin() {
        super("Fire Spin", 's', 70, "spins", 90);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        for(Exit exit: currentLocation.getExits()){
            exit.getDestination().addItem(new Fire());
        }
        super.tick(currentLocation, actor);
    }
}
