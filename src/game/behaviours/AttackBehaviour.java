package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.AttackAction;
import game.elements.Element;
import game.elements.ElementsHelper;

/**
 * The Attack behaviour of Pokemon
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Minh Tuan Le
 */
public class AttackBehaviour implements Behaviour {

    /**
     *
     *  HINT: develop a logic to check surrounding, check elements, and return an action to attack that opponent.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Actor targetedActor = null;
        for (Exit exit : map.locationOf(actor).getExits()){
            targetedActor= map.getActorAt(exit.getDestination());
            if((targetedActor != null) && (ElementsHelper.hasAnySimilarElements(actor, targetedActor.findCapabilitiesByType(Element.class))) ) {
                return new AttackAction(targetedActor, "here");// behaviour will stop here.
            }
        }

        return null; // go to next behaviour
    }
}
