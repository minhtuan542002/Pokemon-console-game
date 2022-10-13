package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.pokemons.Pokemon;

public class EvolveAction extends Action {
    private Pokemon evolvingActor;

    private Pokemon evolvedTarget;

    public EvolveAction(Pokemon evolvingActor, Pokemon evolvedTarget) {
        this.evolvingActor = evolvingActor;
        this.evolvedTarget = evolvedTarget;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
