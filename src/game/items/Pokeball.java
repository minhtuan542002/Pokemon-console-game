package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.FeedPokefruitAction;
import game.action.SummonAction;
import game.pokemons.Pokemon;
import game.trades.Tradable;

/**
 * An item that can contain Pokemon when successfully capturing one and
 * capable of summoning the Pokemon again.
 * Created by:
 * @author Minh Tuan Le
 *
 * Modified by:
 * @author
 */
public class Pokeball extends Item implements Tradable{

    /**
     * The Pokemon contained inside the Pokeball
     */
    private Pokemon pokemon;

    /**
     * Constructor
     * @param pokemon The Pokemon contained inside the Pokeball
     */
    public Pokeball(Pokemon pokemon) {
        super("Pokeball", '0', false);
        this.pokemon =pokemon;
        this.addAction(new SummonAction(this));
    }

    // methods
    @Override
    public Integer getItemCost() {
        // attributes
        return 5;
    }

    /**
     * Clean up all unnecessary data and free resources
     */
    public void remove() {
        pokemon = null;
        this.clearActions();
    }

    /**
     *  Fetch the pokemon inside the Pokeball
     * @return the pokemon inside the Pokeball
     */
    public Pokemon getPokemon() { return this.pokemon;}
/**
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
    */
}