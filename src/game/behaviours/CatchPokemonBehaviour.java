package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.CaptureAction;
import game.action.FeedPokefruitAction;
import game.affection.AffectionManager;

/**
 * The behaviour class for trainer to get the catch pokemon action
 *
 * Created by:
 * @author Minh tuan Le
 */
public class CatchPokemonBehaviour implements Behaviour{

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        for (Exit exit: currentLocation.getExits()){
            if (exit.getDestination().containsAnActor()) {
                Actor target=exit.getDestination().getActor();
                if(target.hasCapability(Status.CATCHABLE)) {
                    return new CaptureAction(AffectionManager.getInstance().findPokemon(target));
                }
            }
        }
        return  null;
    }
}
