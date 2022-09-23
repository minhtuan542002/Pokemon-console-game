package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.trades.Tradable;


public class TradeAction extends Action {


    // attributes:
    // tradable is my interface (still needs implementation)
    // note to self: I gotta make tradable an interface not abstract cause makes easy to add more items in future
    boolean Traded = true;
    public Integer item;
    // cost is how many candies we would need to buy one item
    public Integer cost;
    public Integer candyBalance;


        //constructor
    // put attributes in constructor to store
        public TradeAction(Tradable item, Integer cost) {
        this.item = item.getItemCost();
        this.cost = cost;
    }

    // methods
    // execute method from game engine
    @Override
    public String execute(Actor actor, GameMap map) {
        // Basically, if candy balance < cost (of item)
        // then item is traded

        // get candy balance
        candyBalance = Player.
        // if not, then return not enough candies
        return "you don't have enough candies";
    }

    // menu description method also from game engine
    // used to print message on console
    @Override
    public String menuDescription(Actor actor) {

        return actor + "traded " + item + " for " + cost + " candies.";
    }

}



