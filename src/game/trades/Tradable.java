package game.trades;

import edu.monash.fit2099.engine.actors.Actor;

public interface Tradable {

    // add methods that tradable items can implement (IMPORTANT NOte - should not have a body for methods

    // tradable items should give me thier cost price of Item
    public Integer getItemCost();  // method 1

    // item to be traded by actor
    public static void addToPlayerInventory(Actor actor)     // method 2 - passing Actor, see pokefruit, to get actor engine
    {
        System.out.println("if this line prints then see tradable interface");
    }
}
