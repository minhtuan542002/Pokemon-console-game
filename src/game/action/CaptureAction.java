package game.action;

import javax.swing.*;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
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

    /**
     * Random number generator
     */
    protected Random rand = new Random();
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " tries to capture " + target + " at " + direction;
    }
}
