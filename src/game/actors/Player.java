package game.actors;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.Status;
import game.action.SeeTrainerInfoAction;
import game.affection.AffectionManager;
import game.items.Candy;
import game.time.TimePerceptionManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing the Player.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Minh Tuan Le, Zhijun Chen and Ishrat Kaur
 */

public class Player extends Actor {

	/**
	 *  creates player's inventory as an array list
	 */
	public static ArrayList<Item> playerInventory = new ArrayList<>();

	/**
	 *  displays menu for GUI implementation
	 */
	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.IMMUNE);
		AffectionManager.getInstance().registerTrainer(this);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		// everytime it should print candy list ethe
		System.out.println(Candy.candyList);

		TimePerceptionManager.getInstance().run();

		AffectionManager affectionManager=AffectionManager.getInstance();
		affectionManager.updatePokemonBehaviours();
		for(Actor trainer: affectionManager.getTrainers()) {
			if(!trainer.equals(this)) {
				actions.add(new SeeTrainerInfoAction(trainer));

			}
		}
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}

	/**
	 * method to add item to player's inventory
	 * @param item The Item to add.
	 */
	public void addItemToInventory(Item item) {
		playerInventory.add(item);
	}

	/**
	 * method to remove item from player's inventory
	 * @param item The Item to remove.
	 */
	public void removeItemFromInventory(Item item){
		playerInventory.remove(item);
	}

	/**
	 * method to obtain player's inventory
	 * @return player inventory
	 */
	public List<Item> getInventory() {
		return Collections.unmodifiableList(playerInventory);
	}

}
