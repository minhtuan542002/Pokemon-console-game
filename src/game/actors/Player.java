package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.Status;
import game.action.TradeAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing the Player.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */

// player should store candies in his inventory

public class Player extends Actor {

	public static ArrayList<Item> playerInventory = new ArrayList<>();

	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.IMMUNE);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}

	// adding item to his inventory
	public void addItemToInventory(Item item) {
		playerInventory.remove(item);
	}

	// now removing as well
	public void removeItemFromInventory(Item item){
		playerInventory.remove(item);
	}

	// getting inventory now
	public List<Item> getInventory() {
		return Collections.unmodifiableList(playerInventory);
	}
}
