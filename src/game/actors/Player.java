package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import java.util.HashMap;
import java.util.Map;

public class Player extends Actor {

    Map<String, String> playerInventory = new HashMap<String, String>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Player(String name, char displayChar, int hitPoints) {
        super("Player", '@', hitPoints);            // hitPoints represent the health of the Actor
    }

    // implements methods inherited from parent class
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    // methods
}
