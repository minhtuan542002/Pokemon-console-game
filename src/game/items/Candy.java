package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;

public class Candy extends Item {

    // attributes


    // constructor
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Candy() {
        super("Candy", '*', true);
    }

    // methods
    // using pick up item action from engine to make candy pick able
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return super.getPickUpAction(actor);
    }
}
