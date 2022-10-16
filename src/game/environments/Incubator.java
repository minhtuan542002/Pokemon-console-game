package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Player;
import game.pokemons.*;
import game.trades.Tradable;
import game.trades.TradeAction;

/**
 * Class representing enumeration of type of Candy
 * Created by:
 * @author Ishrat Kaur
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */
public class Incubator extends Ground {


    /**
     * Constructor.
     *
     */
    public Incubator() { super( 'X'); }

    /**
     * Method check if incubator has a pokemon egg, it changes the dropped variable inside pokemon egg to be true
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        for (Item item: location.getItems()){
            if (item instanceof PokemonEgg){
                ((PokemonEgg) item).dropped();
//
            }
        }
        super.tick(location);
    }

    /**
     * Method to add drop item action when a player is at this location and a has a pokemon
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    public ActionList allowableActions(Actor actor, Location location, String direction){


        ActionList actions = new ActionList();
        // to implement trading action for every item that is in nurse's inventory
        if (location.getActor() instanceof Player){
            for (Item item: Player.playerInventory) {
                if (item instanceof PokemonEgg){
                    actions.add(new DropItemAction(item));
                }
            }
        }
        return actions;
    }

}
