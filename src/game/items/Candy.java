package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.trades.Tradable;

import java.util.List;

public class Candy extends Item  {

    private int candyAmount;


    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Candy(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    // methods
    // using pick up item action from engine to make candy pick able
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return super.getPickUpAction(actor);

    }

    @Override
    public List<Action> getAllowableActions() {
        // this should say that basically the player is allowed to pick me up
        return null;
    }

}
