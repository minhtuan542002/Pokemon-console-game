package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.trades.Tradable;

public class Pokefruit extends Item implements Tradable {

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Pokefruit(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * @return
     */
    @Override
    public Integer getItemCost() {
        // attributes
        return 1;
    }

    /**
     * @param actor
     */

    /**
    // note to self: try better name to not get confused b/w engine method and mine
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
    */

    // attributes

    // enumeration defining Pokefruit types as constants
    public enum PokefruitType {
        FIRE,
        WATER,
        GRASS
    }


}


