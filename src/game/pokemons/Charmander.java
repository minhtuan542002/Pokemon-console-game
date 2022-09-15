package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.AttackAction;
import game.Element;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Charmander extends Pokemon {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        this.behaviours.put(10, new WanderBehaviour());
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
