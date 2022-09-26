
package game.action;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Candy;

public class PickUpCandyAction extends PickUpItemAction {

    // attributes

    public Candy candy;

    /**
     * Constructor.
     *
     * @param candy the item to pick up
     */
    public PickUpCandyAction(Candy candy) {
        super(candy);
        this.candy = candy;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        candy.addCandy();
        map.locationOf(actor).removeItem(candy);
        return actor + " picked up candy";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " can pick up " + candy;
    }
}
