package game.trades;
import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface representing Tradable
 * Created by:
 * @author Ishrat Kaur
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */
public interface Tradable {

    /**
     * method to obtain cost of the item
     * @returns item cost
     */
    Integer getItemCost();

    /**
     * method to add item to actor's inventory
     * @param actor is the player
     */
    void addToPlayerInventory(Actor actor);
}
