package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.action.PickUpCandyAction;
import game.actors.Player;
import game.trades.Tradable;

import java.util.ArrayList;
import java.util.List;

public class Candy extends Item  {

    //private String candy = "candy";

    // candy list should be made
    public static ArrayList<String> candyList = new ArrayList<>();

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Candy() {
        super("candy", '*', true);
    }

    // methods
    // using pick up item action from engine to make candy pick able
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCandyAction(this);
    }


//    public List<Action> getAllowableActions() {
//        // this should say that basically the player is allowed to pick me up
//        return null;
//    }

    // i should have a method that allows me to add candies to the candy list that perhaps the player can use
    public void addCandy() {
        candyList.add("candy");
    }
}
