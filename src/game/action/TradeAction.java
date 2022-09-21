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

    // attributes
    Nurse nurse;
    Player player;
    int candyAmount;
    int i;

    tradableItem Pokefruit;

    tradableItem Pokeball;

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }


    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    public String tradeCandy() {

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
            player.removeItemFromInventory(Item candy);

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


}

