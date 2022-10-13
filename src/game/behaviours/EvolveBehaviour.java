package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.EvolveAction;
import game.pokemons.Evolving;

public class EvolveBehaviour implements Behaviour{
    private final Evolving pokemon;
    public EvolveBehaviour(Evolving pokemon){
        this.pokemon=pokemon;
    }
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new EvolveAction(pokemon.getEvolution());
    }
}
