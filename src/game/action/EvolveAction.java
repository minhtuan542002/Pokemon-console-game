package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.affection.AffectionManager;
import game.pokemons.Pokemon;

public class EvolveAction extends Action {

    private Pokemon evolvedTarget;

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
