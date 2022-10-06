package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.SummonAction;
import game.pokemons.Pokemon;
import game.trades.Tradable;

/**
 * Class representing Pokeball
 * Created by:
 * @author Minh Tuan Le and Ishrat Kaur
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */

public class Pokeball extends Item implements Tradable{

    /**
     * The Pokemon contained inside the Pokeball
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
    public Pokeball(Pokemon pokemon) {
        super("Pokeball", '0', false);
        this.pokemon =pokemon;
        this.addAction(new SummonAction(this));
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
     * Clean up all unnecessary data and free resources
     */
    public void remove() {
        pokemon = null;
        this.clearActions();
    }

    /**
     *  implements to fetch the pokemon inside the Pokeball
     * @return the pokemon inside the Pokeball
     */
    public Pokemon getPokemon() { return this.pokemon;}

    /**
     * implements method to add item to player's inventory after successful trade
     * @param actor is the player
     */
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
}