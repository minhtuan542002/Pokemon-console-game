package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.action.CaptureAction;
import game.action.FeedPokefruitAction;
import game.behaviours.EvolveBehaviour;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.actors.AffectionManager;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.specialattacks.BackupWeapons;
import game.time.TimePerception;
import game.time.TimePerceptionManager;

import java.util.Map;
import java.util.TreeMap;

/**
 * The Pokemon class
 * Created by:
 * @author Minh Tuan Le
 */
public abstract class Pokemon extends Actor {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    /**
     * The behaviour list for the Pokemon, sorted by its priority implemented by key
     * The smaller the key, the higher priority of the behaviour
     */
    protected final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * The Backup weapon containing special attack to equip when conditions are met
     */
    protected BackupWeapons backupWeapon;

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

        AffectionManager affectionManager = AffectionManager.getInstance();
        affectionManager.registerPokemon(this);

    }

    /**
     * Add behaviour and its priority to the behaviour list
     *
     * @param priority The priority of the added behaviour
     * @param behaviour The added behaviour
     */
    public void addBehaviour(Integer priority, Behaviour behaviour) {
        behaviours.put(priority, behaviour);
    }

    public void removeBehaviour(Integer priority) { behaviours.remove(priority); }

    /**
     * Add and remove the Special attack from the pokemon inventory
     *
     * @param isEquipping Whether the Special weapon should be in the Inventory - true for yes and false for no.
     * FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     *
     */
    public void toggleWeapon(boolean isEquipping) {
        if(isEquipping) {
            for(WeaponItem weaponItem : backupWeapon.getSpecialWeapon())
                this.addItemToInventory(weaponItem);
        }
        else {
            for(WeaponItem weaponItem : backupWeapon.getSpecialWeapon())
                this.removeItemFromInventory(weaponItem);
        }
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
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        actions.add(new AttackAction(this, direction));
        //Allow pokemon except Charmander to be captured
        actions.add(new CaptureAction(this));

        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        toggleWeapon(new ElementsHelper().hasAnySimilarElements(
                map.locationOf(this).getGround(), this.findCapabilitiesByType(Element.class)
        ));

        AffectionManager affectionManager = AffectionManager.getInstance();
        affectionManager.updatePokemonBehaviours();

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();

    }

    /**
     * Free up all resources in the Pokemon class and related manager classes
     */
    public void remove() {
        behaviours.clear();
        backupWeapon.remove();
        backupWeapon=null;
        AffectionManager affectionManager = AffectionManager.getInstance();
        affectionManager.removePokemon(this);

    }

    /**
     * Print out the current Health point of the Pokemon
     *
     * @return The current health point of the pokemon and its max HP
     */
    public String printHP() {
        return this.printHp();
    }
}
