package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.action.AttackAction;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.affection.AffectionManager;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.specialattacks.BackupWeapons;
import game.time.TimePerception;
import game.time.TimePerceptionManager;

import java.util.Map;
import java.util.TreeMap;

public abstract class Pokemon extends Actor implements TimePerception  {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    protected final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

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

        this.addCapability(Status.CATCHABLE);

        AffectionManager affectionManager = AffectionManager.getInstance();
        affectionManager.registerPokemon(this);
        TimePerceptionManager timePerceptionManager = TimePerceptionManager.getInstance();
        timePerceptionManager.append(this);
    }

    public void addBehaviour(Integer priority, Behaviour behaviour) {
        behaviours.put(priority, behaviour);
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {
        if(isEquipping)this.addItemToInventory(backupWeapon.getSpecialWeapon());
        else this.removeItemFromInventory(backupWeapon.getSpecialWeapon());
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
}
