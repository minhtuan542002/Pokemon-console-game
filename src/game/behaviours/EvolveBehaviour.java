package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.EvolveAction;
import game.pokemons.Evolving;

/**
 * Behaviour class for Pokemon to get the evolve action
 * Created by:
 * @author Minh Tuan Le
 */
public class EvolveBehaviour implements Behaviour{
    /**
     * The pokemon that will evolve in this behaviour
     */
    private final Evolving pokemon;

    /**
     * Constructor
     * @param pokemon The pokemon that will evolve in this behaviour
     */
    public EvolveBehaviour(Evolving pokemon){
        this.pokemon=pokemon;
    }
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new EvolveAction(pokemon.getEvolution());
    }
}
