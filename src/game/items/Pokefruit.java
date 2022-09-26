package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.FeedPokefruitAction;
import game.affection.AffectionManager;
import game.elements.Element;
import game.time.TimePerceptionManager;
import game.trades.Tradable;

public class Pokefruit extends Item implements Tradable {

    private String name;

    /***
     * Constructor.
     */
    public Pokefruit(Element pokeFruitType) {
        super("Pokefruit", 'f', true);
        this.addCapability(pokeFruitType);

        if(pokeFruitType==Element.FIRE) this.name = "Fire Fruit";
        if(pokeFruitType==Element.WATER) this.name = "Water Fruit";
        if(pokeFruitType==Element.GRASS) this.name = "Grass Fruit";
    }

    /**
     * @return
     */
    @Override
    public Integer getItemCost() {
        // attributes
        return 1;
    }

    @Override
    public String toString() {
        return name;
    }

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
     * @param actor
     */

    /**
    // note to self: try better name to not get confused b/w engine method and mine
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
    */

    // attributes



}


