package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.SummonAction;
import game.pokemons.Pokemon;
import game.trades.Tradable;

public class Pokeball extends Item implements Tradable{
    private Pokemon pokemon;

    /***
     * Constructor.
     */
    public Pokeball(Pokemon pokemon) {

        super("Pokeball", '0', true);
        this.pokemon =pokemon;
        this.addAction(new SummonAction(this));
    }

    // methods
    @Override
    public Integer getItemCost() {
        // attributes
        return 5;
    }

    public void remove() {
        pokemon = null;
    }

    public Pokemon getPokemon() { return this.pokemon;}
/**
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }
    */
}