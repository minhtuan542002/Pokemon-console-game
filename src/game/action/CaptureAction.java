package game.action;

import javax.swing.*;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.affection.AffectionManager;
import game.items.Pokeball;
import game.pokemons.Pokemon;

import java.util.Random;

public class CaptureAction extends Action {

    /**
     * The Pokemon that is to be captured
     */
    protected Pokemon target;

    /**
     * The direction of the Pokemon that is to be captured.
     */
    protected String direction;

    public CaptureAction(Pokemon target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        AffectionManager affectionManager = AffectionManager.getInstance();
        if(target.hasCapability(Status.CATCHABLE)) {
            Pokeball pokeball = new Pokeball(target);
            map.removeActor(target);
            actor.addItemToInventory(pokeball);
            return target + " is captured successfully! ";
        }
        else {
            target.removeCapability(Status.CATCHABLE);
            affectionManager.decreaseAffection(target,10);
            return "Failed to capture " + target + "! -10 affection points. This Pokemon can no longer be captured.";
        }

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " catches " + AffectionManager.getInstance().printAffectionPoint(target);
    }
}
