package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.SummonAction;
import game.actors.Player;
import game.environments.Incubator;
import game.trades.Tradable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing TradeAction
 * Created by:
 * @author Ishrat Kaur
 * Modified by: Minh Tuan Le, and Ishrat Kaur
 */

public class PokemonEgg extends Item implements Tradable {

    /**
     * private integer for hashTime representing number of turns taken by pokemon egg to hatch
     */
    private int hatchTime;

    /**
     * Private Boolean to keep track if Pokemon egg has been dropped
     */
    private boolean dropped = false;

    /**
     * The Pokemon contained inside the PokemonEgg
     */
    private Pokemon pokemon;

    /**
     * private attribute cost defined as an integer
     */
    private int cost = 5;



    /**
     * Constructor
     * @param pokemon is an actor in the game
     */
    public PokemonEgg(Pokemon pokemon) {
        super(pokemon + "PokemonEgg", 'g', true);
        this.pokemon = pokemon;
    }

    /**
     * method to obtain cost of an item
     * @return cost of item
     */
    @Override
    public Integer getItemCost() {
        return cost;
    }

    /**
     * Method to obtain Pokemon
     * @return pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * method call to change dropped variable's value to true
     */
    public void dropped() {
        dropped = true;
    }

    /**
     * implements method to add item to player's inventory after successful trade
     * @param actor is the player
     */
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }


    /**
     * Method to keep track of time. Even egg is dropped, hatch time is used to track the time (turns) required to hatch
     * @param location The location of the ground on which we lie.
     */
    public void tick(Location location) {
        if (dropped == true){

            hatchTime ++;

            if (hatchTime == 2 && pokemon instanceof Squirtle ) {
                location.addActor(new Squirtle());
            }

            if (hatchTime == 3 && pokemon instanceof Bulbasaur ) {
                location.addActor(new Bulbasaur());
            }

            if (hatchTime == 4 && pokemon instanceof Charmander ) {
                location.addActor(new Charmander());
            }
        }



    }
}
