package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actors.AffectionManager;
import game.items.Candy;
import game.items.Pokeball;
import game.pokemons.Pokemon;

/**
 * An Action to catch a Pokemon.
 *  Created by:
 *  @author Minh Tuan Le
 */
public class CaptureAction extends Action {

    /**
     * The Pokemon that is to be captured
     */
    private Pokemon target;


    /**
     * Constructor
     * @param target the target of the capture Action
     */
    public CaptureAction(Pokemon target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        AffectionManager affectionManager = AffectionManager.getInstance();
        if(target.hasCapability(Status.CATCHABLE)) {
            Pokeball pokeball = new Pokeball(target);
            map.removeActor(target);
            actor.addItemToInventory(pokeball);
            map.locationOf(actor).addItem(new Candy());
            return target + " is captured successfully! ";
        }
        else {
            target.removeCapability(Status.CATCHABLE);
            affectionManager.decreaseAffection(actor, target,10);
            return "Failed to capture " + target + "! -10 affection points. This Pokemon can no longer be captured.";
        }

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " catches " + AffectionManager.getInstance().printAffectionPoint(actor, target);
    }
}
