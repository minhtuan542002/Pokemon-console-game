package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Pokeball;
import game.pokemons.Pokemon;

import javax.swing.*;
import java.util.Random;

public class SummonAction extends Action {
    /**
     * The Pokeball that is to be summoned
     */
    protected Pokeball summon;

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "I choose you... " + summon.getPokemon() + " !";
    }

}
