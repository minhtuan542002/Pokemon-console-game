package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.trades.Tradable;

public class Pokeball extends Item implements Tradable{

    // attributes:
    private int cost = 5;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
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
     *  Fetch the pokemon inside the Pokeball
     * @return the pokemon inside the Pokeball
     */
    public Pokemon getPokemon() { return this.pokemon;}

    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
}