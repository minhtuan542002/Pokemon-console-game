package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action.CaptureAction;
import game.action.FeedPokefruitAction;
import game.affection.AffectionManager;
import game.behaviours.*;

import java.util.Map;
import java.util.TreeMap;

public class Trainer extends Actor {
    /**
     * The behaviour list for the trainer, sorted by its priority implemented by key
     * The smaller the key, the higher priority of the behaviour
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Trainer(String name, char displayChar, int hitPoints) {

        super(name, displayChar, hitPoints);
        this.addCapability(Status.IMMUNE);
        this.behaviours.put(10, new WanderBehaviour());
        this.behaviours.put(9, new PickUpItemBehaviour());
        this.behaviours.put(8, new FeedPokefruitBehaviour());
        this.behaviours.put(7, new CatchPokemonBehaviour());
    }

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
