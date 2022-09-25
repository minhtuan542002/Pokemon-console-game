package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Pokeball;
import game.pokemons.Pokemon;

import javax.swing.*;
import java.util.Random;

public class SummonAction extends Action {
    /**
     * The Pokeball that is to be summoned
     */
    protected Pokeball summon;

    public SummonAction(Pokeball pokeball) {
        this.summon = pokeball;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location summonSpot = null;
        for (Exit exit : map.locationOf(actor).getExits()) {
            if(exit.getDestination().canActorEnter(summon.getPokemon())){
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
            summon.remove();
            return summon.getPokemon() + "has been summoned!";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "I choose you... " + summon.getPokemon() + " !";
    }

}
