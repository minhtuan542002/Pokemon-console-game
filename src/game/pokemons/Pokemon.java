package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.action.AttackAction;
import game.action.CaptureAction;
import game.action.FeedPokefruitAction;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.affection.AffectionManager;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.items.Pokefruit;
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
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        actions.add(new AttackAction(this, direction));
        //Allow pokemon with catchable status to be captured
        if(this.hasCapability(Status.CATCHABLE)) { actions.add(new CaptureAction(this, direction));}
        //Allow player to feed Pokefruit to pokemon
        if((!this.hasCapability(Status.HOSTILE))) {
            Pokefruit firePokefruit = null,
                    grassPokefruit = null,
                    waterPokefruit = null;
            for (Item item : otherActor.getInventory()) {
                if (item.toString() == "Pokefruit" || item.getDisplayChar()=='f') {
                    Pokefruit pokefruit = (Pokefruit) item;
                    if (pokefruit.hasCapability(Element.FIRE)) {
                        firePokefruit = pokefruit;
                    }
                    if (pokefruit.hasCapability(Element.WATER)) {
                        waterPokefruit = pokefruit;
                    }
                    if (pokefruit.hasCapability(Element.GRASS)) {
                        grassPokefruit = pokefruit;
                    }
                }
            }
            if(waterPokefruit != null) actions.add(new FeedPokefruitAction(this,waterPokefruit));
            if(firePokefruit != null) actions.add(new FeedPokefruitAction(this,firePokefruit));
            if(grassPokefruit != null) actions.add(new FeedPokefruitAction(this,grassPokefruit));
        }

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

    public void remove() {
        behaviours.clear();
        backupWeapon.remove();
        backupWeapon=null;
        AffectionManager affectionManager = AffectionManager.getInstance();
        affectionManager.removePokemon(this);
        TimePerceptionManager timePerceptionManager = TimePerceptionManager.getInstance();
        timePerceptionManager.cleanUp(this);
    }

    public String printHP() {
        return this.printHp();
    }
}
