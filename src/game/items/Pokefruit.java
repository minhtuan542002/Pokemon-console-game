package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.elements.Element;
import game.trades.Tradable;

public class Pokefruit extends Item implements Tradable {
    Element pokeFruitType;

    /***
     * Constructor.
     */
    public Pokefruit(Element pokeFruitType) {

        super("Pokefruit", 'f', true);
        this.pokeFruitType = pokeFruitType;
    }

    /**
     * @return
     */
    @Override
    public Integer getItemCost() {
        // attributes
        return 1;
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


