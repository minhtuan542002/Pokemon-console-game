package game.Actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Candy;

public class PickUpCandyAction extends PickUpItemAction {

    public Candy candy;

    public PickUpCandyAction(Candy candy){
        super(candy);
        this.candy = candy;
    }

    public String execute(Actor actor, GameMap map){
        map.locationOf(actor).removeItem(candy);
        return actor + " picked up " + candy;
    }
}
