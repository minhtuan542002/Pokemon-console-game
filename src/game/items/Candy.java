package game.items;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.action.DropCandyAction;
import game.action.PickUpCandyAction;
import game.actors.Player;
import game.trades.Tradable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing enumeration of type of Candy
 * Created by:
 * @author Ishrat Kaur
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */

public class Candy extends Item  {

    /**
     * creates a list of candies
     */
    public static ArrayList<String> candyList = new ArrayList<>();


    /**
     * integer representing candy balance, given by the length of the array
     */
    public static int candyBalance = candyList.size();

    /**
     * Constructor
     */
    public Candy() {
        super("candy", '*', true);
    }

    /**
     * method allows actor to pick up a candy
     * @param actor is the player
     * @returns a new pickup candy action
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCandyAction(this);
    }

    /**
     * method allows actor to drop a candy
     * @param actor is the player
     * @returns a new pickup candy action
     */
    @Override
    public DropItemAction getDropAction(Actor actor) { return new DropCandyAction(this); }

    /**
     * method to add candy to the candy list
     */
    public void addCandy() {
        candyList.add("candy");
        candyBalance += 1;
    }

    /**
     * method allows actor to drop a candy
     * @returns a new pickup candy action
     */
    public void dropCandy() {
        candyList.remove(0);
        candyBalance -= 1;
    }


}
