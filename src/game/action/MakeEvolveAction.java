package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemons.Evolving;
import game.pokemons.Pokemon;

public class MakeEvolveAction extends Action {
    private final Pokemon evolvingTarget;
    private final Pokemon evolvedTarget;

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
