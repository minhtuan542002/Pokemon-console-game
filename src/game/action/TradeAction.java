package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Nurse;

public class TradeAction extends Action {

    // attributes
    Nurse nurse;


    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }


    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    public void tradeCandy() {
        /**
         * if candies offered by player = 1
         *  return pokefruit
         *          (removes one candy from playerInventory)
         *          (adds one candy to nurseInventory)
         *
         * if candies offered by player = 5
         *  return pokeball
         *          (removes five candies from playerInventory)
         *          (adds five candies to nurseInventory)
         *
         */

        // work on player's inventory and then come back here to continue this
    }


}

