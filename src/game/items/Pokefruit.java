package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.FeedPokefruitAction;
import game.elements.Element;
import game.trades.Tradable;

/**
 * Class representing Pokefruit
 * Created by:
 * @author Minh Tuan Le
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */

public class Pokefruit extends Item implements Tradable {
    /**
     * cost of pokefruit defined as a private integer
     */
    private int cost = 1;

    /***
     * Constructor.
     *  @param pokeFruitType The element of the Pokefruit
     */
    public Pokefruit(Element pokeFruitType) {
        super(pokeFruitType.toString()+ " Pokefruit", 'f', true);
        this.addCapability(pokeFruitType);
        this.addCapability(ItemType.POKEFRUIT);

    }

    /**
     * method from tradabel interface to return cost of item
     * @return cost of the item
     */
    @Override
    public Integer getItemCost() {
        // attributes
        return cost;
    }

    /**
     *
     * @param location The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location location, Actor actor) {
        if(actor.getInventory().contains(this)) {
            for (Exit exit : location.getExits()) {
                Actor otherActor = exit.getDestination().getActor();
                if (otherActor != null) {
                    if (otherActor.hasCapability(Status.CAN_CONSUME_POKEFRUIT)) {
                        this.addAction(new FeedPokefruitAction(otherActor, this));
                    }
                }
            }
        }
        else this.clearActions();
    }

    /**
     * method from tradable interface to add item to actor's inventory
     * @param actor is the player
     */
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }


}


