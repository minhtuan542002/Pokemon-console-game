package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.elements.Element;
import game.trades.Tradable;

public class Pokefruit extends Item implements Tradable {
    Element pokeFruitType;

    private String name;

    /***
     * Constructor.
     */
    public Pokefruit(Element pokeFruitType) {
        super("Pokefruit", 'f', true);
        this.pokeFruitType = pokeFruitType;
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

    public void remove() {
        pokeFruitType=null;
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


