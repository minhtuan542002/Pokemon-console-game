package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.trades.TradeAction;
import game.elements.Element;
import game.pokemons.Charmander;
import game.trades.Tradable;
import game.items.Pokeball;
import game.items.Pokefruit;
import game.trades.TradeAction;


import java.util.HashMap;

/**
 * Class representing Pokefruit
 * Created by:
 * @author Ishrat Kaur
 */

public class Nurse extends Actor {

    /**
     * Created a hashmap for a list of items that nurse joy can trade
     */
    private HashMap<String, Tradable> nurseTradableList =  new HashMap<>();

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

    @Override // implements method inherited
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // nurse should show tradable items in her inventory,
        // hashmap syntax https://edstem.org/au/courses/8750/lessons/22738/slides/160450
        nurseTradableList.put("Fire Pokefruit", new Pokefruit(Element.FIRE));
        nurseTradableList.put("Water Pokefruit", new Pokefruit(Element.WATER));
        nurseTradableList.put("Grass Pokefruit", new Pokefruit(Element.GRASS));
        nurseTradableList.put("Pokeball", new Pokeball(new Charmander()));
        return new DoNothingAction();
    }

    /**
     * allows implementation of trade action for every tradable item in nurse's inventory
     * @return the actions allowed
     */
    public ActionList allowableActions () {
        ActionList actions = new ActionList();
        // to implement trading action for every item that is in nurse's inventory
        for (Tradable item: nurseTradableList.values()) {
            actions.add(new TradeAction(item, item.getItemCost()));
        }
        return actions;
    }


}


