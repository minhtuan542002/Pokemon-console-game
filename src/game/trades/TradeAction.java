package game.trades;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.items.Candy;
import game.trades.Tradable;

/**
 * Class representing TradeAction
 * Created by:
 * @author Ishrat Kaur
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */

public class TradeAction extends Action {

    /**
     * item of type Tradable interface defined as protected
     */
    protected Tradable item;

    /**
     * cost of item defined as an integer
     */
    private int cost;

    /**
     * number of candies player has defined as an integer
     */
//    private int candyBalance;

    /**
     * Constructor
     * @param item is the item being traded
     * @param cost is the number of candies required to buy the item
     */
    public TradeAction(Tradable item, int cost){
        this.item = item;
        this.cost = cost;
    }

    /**
     * execute method from game engine is used to execute TradeAction
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return an output when there are insufficient candies in player's inventory to continue the trade
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        /** candy balance is obtained by finding length of player's inventory */
//        candyBalance = Candy.candyList.size() + 1;
        System.out.println(Candy.candyBalance);
        System.out.println(Player.playerInventory);

        /** if conditional to check if there are enough candies to trade the item */
        if (Candy.candyBalance >= cost) {
            item.addToPlayerInventory(actor);

            for (int i =0; i < cost; i++){
                Candy.candyList.remove(0);
                Candy.candyBalance -= 1;
            }
            return "Traded " + item+ "successfully";
        } else {
            /** returns a message if player does not have enough candies */
            return "you don't have enough candies";
        }

    }

    /**
     * method from game engine used to print message to console after a successful trade
     * @param actor The actor performing the action.
     * @return that the player has traded the respective item successfully
     */
    @Override
    public String menuDescription(Actor actor) {

        return actor + " can trade " + item;
    }

}



