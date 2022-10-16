package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.pokemons.Bulbasaur;
import game.pokemons.PokemonEgg;
import game.pokemons.Squirtle;
import game.trades.TradeAction;
import game.elements.Element;
import game.pokemons.Charmander;
import game.trades.Tradable;
import game.items.Pokeball;
import game.items.Pokefruit;
import game.trades.TradeAction;


import java.util.HashMap;
import java.util.Map;

/**
 * Class representing Pokefruit
 * Created by:
 * @author Ishrat
 * editing by: Minh Tuan
 */

public class Nurse extends Actor {

    /**
     * Created a hashmap for a list of items that nurse joy can trade
     */
    private HashMap<String, Tradable> nurseTradableList =  new HashMap<>();

    /**
     * Constructor
     */
    public Nurse() {
        super("Nurse Joy", '%', 1);
        // NOTE TO SELF: add tradable items in here
    }

    /**
     * creates new hashmap with all the tradable items that nurse joy can trade
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override // implements method inherited
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // nurse should show tradable items in her inventory,
        // hashmap syntax https://edstem.org/au/courses/8750/lessons/22738/slides/160450
        nurseTradableList=new HashMap<>();
        nurseTradableList.put("Fire Pokefruit", new Pokefruit(Element.FIRE));
        nurseTradableList.put("Water Pokefruit", new Pokefruit(Element.WATER));
        nurseTradableList.put("Grass Pokefruit", new Pokefruit(Element.GRASS));
        nurseTradableList.put("Pokeball", new Pokeball(new Charmander()));
        nurseTradableList.put("Charmander Egg", new PokemonEgg(new Charmander()));
        nurseTradableList.put("Squirtle Egg", new PokemonEgg(new Squirtle()));
        nurseTradableList.put("Bulbasaur Egg", new PokemonEgg(new Bulbasaur()));
        return new DoNothingAction();

    }

    /**
     * allows implementation of trade action for every tradable item in nurse's inventory
     * @return the actions allowed
     */
    @Override
    public ActionList allowableActions (Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // to implement trading action for every item that is in nurse's inventory
        for (Tradable item: nurseTradableList.values()) {
            actions.add(new TradeAction(item, item.getItemCost()));
        }
        return actions;
    }


}


