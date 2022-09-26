package game.action;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Candy;

public class DropCandyAction extends DropItemAction {


    /**
     * candy of type Candy defined
     */
    protected Candy candy;


    /**
     * Constructor.
     * @param candy the item to be picked up
     */
    public DropCandyAction(Candy candy) {
        super(candy);
        this.candy = candy;
    }
    /**
     * Drop the item.
     *
     * @param actor The actor performing the action
     * @param map The map the actor is on
     * @return a description of the action suitable for feedback in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        candy.dropCandy();
        map.locationOf(actor).addItem(candy);
        return menuDescription(actor);
    }

    /**
     * A string describing the action suitable for displaying in the UI menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player drops the potato"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " drops the " + candy;
    }
}
