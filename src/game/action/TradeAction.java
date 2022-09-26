package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.trades.Tradable;

public class TradeAction extends Action {

    // attributes:
    // tradable is my interface (still needs implementation)
    // note to self: I got to make tradable an interface not abstract cause makes easy to add more items in future

    public Tradable item;
    // cost is how many candies we would need to buy one item
    public int cost;
    public int candyBalance;

    public TradeAction(Tradable item, int cost){
        this.item = item;
        this.cost = cost;
    }

    // methods
    // execute method from game engine
    @Override
    public String execute(Actor actor, GameMap map) {
        // Basically, if candy balance < cost (of item)
        // then item is traded

        // get candy balance
        candyBalance = Player.playerInventory.size() + 1;
        System.out.println(Player.playerInventory);

        if (candyBalance >= cost) {
            item.addToPlayerInventory(actor);
            // NOTE TO SELF - HOW DO I DELETE MY CANDIES ????? DO I GO IN PLAYER CLASS AND CAUSE A VOILATION OF PRINCIPLES
        }

        // if not, then return not enough candies
        return "you don't have enough candies";
    }

    // menu description method also from game engine
    // used to print message on console
    @Override
    public String menuDescription(Actor actor) {

        return actor + "traded " + item + " successfully ";
    }

}



