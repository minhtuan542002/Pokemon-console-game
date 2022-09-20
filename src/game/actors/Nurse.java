package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Nurse extends Actor {

    // making nurse's inventory:
    ArrayList<Item> nurseInventoryImmutable = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */

    // note to self: nurse joy is non-playable actor so she needs a list of behaviours to help her perform actions
    public Nurse(String name, char displayChar, int hitPoints) {
        super("Nurse Joy", '%', hitPoints);
    }

    @Override // implements method inherited
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    // print a list of things ready to be traded - this i will do in trade action


    // gets inventory from engine but problem is this inventory is not mutable
    public List<Item> getInventory() {
        return Collections.unmodifiableList(nurseInventoryImmutable);
    }

    // so i try to make the inventory mutable
    public static List<Item> nurseInventory = new ArrayList<>(nurseInventoryImmutable);

    // now nurseInventory is nurse's inventory that can be changed
    // now i should use this inventory in trade action to do the trading logic
}


