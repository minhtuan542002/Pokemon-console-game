package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Nurse;
import game.actors.Player;
import game.items.Candy;
import game.items.tradableItem;

public class TradeAction extends Action {


    // attributes:
    // tradable is my interface (still needs implementation)
    // note to self: I gotta make tradable an interface not abstract cause makes easy to add more items in future
    private Tradable item;
    // cost is how many candies we would need to buy one item
    private Integer cost;

    //constructor
    // put attributes in constructor to store
    public TradeAction(Tradable item, Integer cost) {
        this.item = item;
        this.cost = cost;
    }

    // methods
    // execute method from game engine
    @Override
    public String execute(Actor actor, GameMap map) {
        // confusion ???
        // work on tradable and then come back
        return null;
    }

    // menu description method also from game engine
    // used to print message on console
    @Override
    public String menuDescription(Actor actor) {

        return actor + "traded " + item + " for " + cost + " candies.";
    }


}


        /**
         *
         * Notes from consultation - instead of mkaing new methods focus on using execute method from engine
         *
        // work on player's inventory and then come back here to continue this
        // both player and nurse's inventory looks sorted, so now i do this logic in trade action

        // print player's inventory to console
        System.out.println(Player.playerInventory);

        // ask player which item he wants to buy using menu description
        menuDescription(Player player){
            return "Do you want pokeball or pokefruit";
        }

        // maybe get player's input using a hotkey
        hotkey(){
            return "y";
        }

        // check how many candies player has
        candyAmount = Player.playerInventory.size() + 1;
        System.out.println(candyAmount);

        if (candyAmount < 1) {
            // not enough candies
            System.out.println("Not enough candies");
        }
        else if (candyAmount == 1) {
            // remove one candy from player's inventory;
            player.removeItemFromInventory(Candy candy);

            // add one pokefruit to player's inventory
            player.addItemToInventory(Item );
        }

        else if (candyAmount == 5) {
            // remove five candies from player's inventory
            for (i = 0; i < 5; i++) {
                player.removeItemFromInventory();
            }
            // add one pokeball to player's inventory
            player.addItemToInventory();
        }

    }
*/



