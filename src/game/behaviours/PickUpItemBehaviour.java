package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class PickUpItemBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        if( currentLocation.getItems().size()>0) {
            for (Item item : currentLocation.getItems()) {
                if (item.getPickUpAction(actor) != null) {
                    return item.getPickUpAction(actor);
                }
            }
        }
        return null;
    }
}
