package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.trades.Tradable;

public class Pokefruit extends Item implements Tradable {

    // attributes
    private int cost = 1;

    // constructor
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Pokefruit(String name, char displayChar, boolean portable) {
        super("Pokefruit", 'f', true);
        //
    }

    // methods
    @Override
    public Integer getItemCost() {
        return cost;
    }



}


