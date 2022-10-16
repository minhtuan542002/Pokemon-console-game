package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.affection.AffectionManager;
import game.pokemons.Pokemon;

/**
 * Action of Pokemon to evolve to the next evolution
 * Created by
 * @author Minh Tuan Le
 */
public class EvolveAction extends Action {
    /**
     * The next evolution the pokemon will turn into
     */
    private Pokemon evolvedTarget;

    /**
     * Constructor
     * @param evolvedTarget The next evolution the pokemon will turn into
     */
    public EvolveAction(Pokemon evolvedTarget) {
        this.evolvedTarget = evolvedTarget;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        map.removeActor(actor);
        AffectionManager.getInstance().removePokemon(actor);
        currentLocation.addActor(evolvedTarget);
        return actor+ " has evolved into "+ evolvedTarget+ "!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor+ " evolves into "+ evolvedTarget;
    }
}
