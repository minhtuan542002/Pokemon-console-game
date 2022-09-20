package game.Items;

import edu.monash.fit2099.engine.items.Item;

public abstract class TradableItem extends Item {

    // attributes
    private

    // constructor
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    TradableItem(String name, char displayChar, boolean portable) {

        super(name, displayChar, portable);
    }


    // methods

}