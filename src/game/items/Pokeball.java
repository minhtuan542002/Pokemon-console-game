package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.pokemons.Pokemon;
import game.trades.Tradable;

public class Pokeball extends Item implements Tradable{

    /***
     * Constructor.
     */
    public Pokeball(Pokemon pokemon) {

        super("Pokeball", '0', true);
    }

    // methods
    @Override
    public Integer getItemCost() {
        // attributes
        return 5;
    }
/**
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
    */
}