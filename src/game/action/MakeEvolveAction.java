package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemons.Evolving;
import game.pokemons.Pokemon;

/**
 * A class for the trainer action of manually make pokemon evolve
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class MakeEvolveAction extends Action {
    /**
     * The pokemon to be made to evolve
     */
    private final Pokemon evolvingTarget;

    /**
     * The next evolution of the pokemon made to evolve
     */
    private final Pokemon evolvedTarget;

    /**
     * Constructor
     * @param evolvingTarget The pokemon to be made to evolve
     * @param evolvedTarget The next evolution of the pokemon made to evolve
     */
    public MakeEvolveAction(Pokemon evolvingTarget, Pokemon evolvedTarget){
        this.evolvingTarget=evolvingTarget;
        this.evolvedTarget = evolvedTarget;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        Location pokemonLocation = map.locationOf(evolvingTarget);
        map.removeActor(evolvingTarget);
        evolvingTarget.remove();
        pokemonLocation.addActor(evolvedTarget);
        return actor+ " has made "+ evolvingTarget+ " evolve into "+ evolvedTarget+ "!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor+ " makes "+ evolvingTarget+ " evolve into "+ evolvedTarget;
    }
}
