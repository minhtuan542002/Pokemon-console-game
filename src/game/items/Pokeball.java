package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.trades.Tradable;

public class Pokeball extends Item implements Tradable{

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Pokeball(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    // methods
    @Override
    public Integer getItemCost() {
        // attributes
        return 5;
    }
/**
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
    */
}