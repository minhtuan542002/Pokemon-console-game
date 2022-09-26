package game.action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Candy;

/**
 * Class representing PickUpItemAction
 * Created by:
 * @author Ishrat Kaur
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */
public class PickUpCandyAction extends PickUpItemAction {

    /**
     * candy of type Candy defined
     */
    protected Candy candy;

    /**
     * Constructor.
     * @param candy the item to be picked up
     */
    public PickUpCandyAction(Candy candy) {
        super(candy);
        this.candy = candy;
    }

    /**
     * execute method from the game engine is used to run PickUpCandyAction
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message informing that the actor picked up the candy
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        candy.addCandy();
        map.locationOf(actor).removeItem(candy);
        return actor + " picked up candy";
    }

    /**
     * menusDescription action from the game engine is used to print a message to console
     * @param actor The actor performing the action.
     * @return a output informing that the actor can pick up candy
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " can pick up " + candy;
    }
}
