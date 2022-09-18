package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Candy;
import game.Items.Pokeball;
import game.Items.Pokefruit;
import game.Items.TradableItem;

import java.util.HashMap;

public class Nurse extends Actor {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Nurse(String name, char displayChar, int hitPoints) {
        super("Nurse", '%', hitPoints);
    }

    public HashMap<String, TradableItem> tradableItems = new HashMap<>();


    // method inherited from parent class
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        super.playTurn(actions, lastAction, map, display);
        tradableItems.put("PokeFruit", new Pokefruit());
        tradableItems.put("PokeBall", new Pokeball());


        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

    }
    // methods

}
