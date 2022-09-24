package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.TradeAction;
import game.elements.Element;
import game.pokemons.Charmander;
import game.trades.Tradable;
import game.items.Pokeball;
import game.items.Pokefruit;


import java.util.HashMap;


public class Nurse extends Actor {

    // note to self: nurse joy is non-playable actor so, she needs a list of behaviours to help her perform actions
    public HashMap<String, Tradable> nurseTradableList =  new HashMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Nurse(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
    // what has nurse to do, a nurse should give player a list of tradable items.
    // so step 1 - print to console a list of tradable items - which are pokeball (with charmander inside) and pokefruit (of three types)
    //


    @Override // implements method inherited
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // nurse should show tradable items in her inventory,
        // hashmap syntax https://edstem.org/au/courses/8750/lessons/22738/slides/160450
        nurseTradableList.put("Pokefruit", new Pokefruit(Element.FIRE));
        nurseTradableList.put("Pokefruit", new Pokefruit(Element.WATER));
        nurseTradableList.put("Pokefruit", new Pokefruit(Element.GRASS));
        nurseTradableList.put("Pokeball", new Pokeball(new Charmander()));

        // use do nothing action instead of null as null would crash the engine
        return new DoNothingAction();
    }

    public ActionList allowableActions () {
        ActionList actions = new ActionList();
        // to implement trading action for every item that is in nurse's inventory
        for (Tradable item: nurseTradableList.values()) {
            actions.add(new TradeAction());
        }
        return actions;
    }
}


