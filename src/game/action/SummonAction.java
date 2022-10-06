package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Pokeball;

/**
 * The Action to summon a Pokemon from a Pokeball
 */
public class SummonAction extends Action {
    /**
     * The Pokeball containing the Pokemon to be summoned
     */
    private Pokeball summon;

    /**
     * Constructor
     * @param pokeball The Pokeball containing the Pokemon to be summoned
     */
    public SummonAction(Pokeball pokeball) {
        this.summon = pokeball;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location summonSpot = null;
        for (Exit exit : map.locationOf(actor).getExits()) {
            if((exit.getDestination().canActorEnter(summon.getPokemon())) && (!exit.getDestination().containsAnActor())){
                summonSpot = exit.getDestination();
                break;
            }
        }
        if(summonSpot == null) {
            return "There are no space next to you to summon the Pokemon!";
        }
        else {
            summonSpot.addActor(summon.getPokemon());
            actor.removeItemFromInventory(summon);
            return summon.getPokemon() + "has been summoned!";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "I choose you... " + summon.getPokemon() + " !";
    }

}
