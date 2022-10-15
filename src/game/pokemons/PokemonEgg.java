package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.SummonAction;
import game.trades.Tradable;

import java.util.ArrayList;
import java.util.List;

public class PokemonEgg extends Item implements Tradable {

    /**
     * private integer for hashTime representing number of turns taken by pokemon egg to hatch
     */
    private int hatchTime;

    private boolean consumed = true;

    /**
     * The Pokemon contained inside the PokemonEgg
     */
    private Pokemon pokemon;

    /**
     * private attribute cost defined as an integer
     */
    private int cost = 5;

    /**
     * Constructor
     * @param pokemon is an actor in the game
     */
    public PokemonEgg(Pokemon pokemon) {
        super("PokemonEgg", 'g', false);
        this.pokemon = pokemon;
    }

    /**
     * method to obtain cost of an item
     * @return cost of item
     */
    @Override
    public Integer getItemCost() {
        return cost;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void dropped(Actor actor, GameMap map) {

    }
    /**
     * implements method to add item to player's inventory after successful trade
     * @param actor is the player
     */
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }



    @Override
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new DropItemAction(this));
        return super.getAllowableActions();
    }
}
