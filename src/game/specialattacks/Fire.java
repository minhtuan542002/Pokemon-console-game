package game.specialattacks;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.elements.Element;

/**
 * Item to create special effect for Special attack FireSpin of Charizard
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class Fire extends Item {
    /**
     * Number of turns since it is created, used to remove it after some time
     */
    private int turnCount=0;
    /***
     * Constructor.
     */
    public Fire() {
        super("Fire", 'v', false);

    }

    @Override
    public void tick(Location currentLocation) {
        turnCount++;
        if(turnCount>=2) {
            currentLocation.removeItem(this);
        }
        if(currentLocation.containsAnActor()) {
            Actor target =currentLocation.getActor();
            if(
                    (!target.findCapabilitiesByType(Status.class).contains(Status.IMMUNE))
                            &&(!target.findCapabilitiesByType(Element.class).contains(Element.FIRE)))
                target.hurt(10);

        }
        super.tick(currentLocation);
    }
}
