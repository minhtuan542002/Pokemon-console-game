package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.action.SummonAction;
import game.trades.Tradable;

public class PokemonEgg extends Item implements Tradable {

    /**
     * private integer for hashTime representing number of turns taken by pokemon egg to hatch
     */
    private int hatchTime;

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

    /**
     * implements method to add item to player's inventory after successful trade
     * @param actor is the player
     */
    @Override
    public void addToPlayerInventory(Actor actor) {
        actor.addItemToInventory(this);
    }

    public void tick(Location location) {
        hatchTime ++;
        if (hatchTime == 2 ) {  // && pokemon ==
            location.addActor(new Squirtle());
        }
        if (hatchTime == 3) {
            if (location.containsAnActor()){
                for (Exit exits: location.getExits()){

                    if (!exits.getDestination().containsAnActor()){
                        exits.getDestination().addActor(new Bulbasaur());
                        break;
                    }
                }
            }else{
                location.addActor(new Bulbasaur()); // for bulbasaur
            }
//
        }
        if (hatchTime == 4) {
            location.addActor(new Charmander()); // for charmander
        }

    }

}
