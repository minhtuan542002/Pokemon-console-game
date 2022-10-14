package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.CaptureAction;
import game.action.FeedPokefruitAction;
import game.affection.AffectionManager;
import game.items.ItemType;

public class FeedPokefruitBehaviour implements Behaviour{

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        for (Exit exit: currentLocation.getExits()){
            if (exit.getDestination().containsAnActor()) {
                Actor target=exit.getDestination().getActor();
                if(target.hasCapability(Status.CAN_CONSUME_POKEFRUIT)) {
                    for (Item item : actor.getInventory()) {
                        if (item.hasCapability(ItemType.POKEFRUIT)) {
                            return new FeedPokefruitAction(exit.getDestination().getActor(), item);
                        }
                    }
                }
            }
        }
        return null;
    }
}
