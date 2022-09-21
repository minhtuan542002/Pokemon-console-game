package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Element;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.specialattacks.BackupWeapons;
import game.time.TimePerception;

import java.util.Map;
import java.util.TreeMap;

public abstract class Pokemon extends Actor implements TimePerception  {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    protected final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    protected final BackupWeapons backupWeapon;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Pokemon(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(10, new WanderBehaviour());
        this.behaviours.put(9, new AttackBehaviour());
        backupWeapon = new BackupWeapons(findCapabilitiesByType(Class<Element<?>>));
    }

    public void addBehaviour(Integer priority, Behaviour behaviour) {
        behaviours.put(priority, behaviour);
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {
        backupWeapon.updateWeapon(this);
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
}
