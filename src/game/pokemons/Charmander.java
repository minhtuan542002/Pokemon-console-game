package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.action.MakeEvolveAction;
import game.affection.AffectionManager;
import game.behaviours.EvolveBehaviour;
import game.elements.Element;
import game.specialattacks.BackupWeapons;
import game.specialattacks.Ember;
import game.specialattacks.FireSpin;
import game.time.TimePerception;

/**
 * Pokemon Charmander
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Minh Tuan Le
 */
public class Charmander extends Pokemon implements TimePerception, Evolving {
    /**
     * The count of turn since the instance was created, used for evolution
     */
    private int turnCount=0;

    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        this.addCapability(Evolution.BASE);
        this.registerInstance();
        backupWeapon = new BackupWeapons(new Ember());
    }


    @Override
    public Pokemon getEvolution() {
        return new Charmeleon();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions= super.allowableActions(otherActor, direction, map);
        AffectionManager affectionManager=AffectionManager.getInstance();
        if(affectionManager.getTrainers().contains(otherActor)){
            if(affectionManager.getAffectionPoint(otherActor,this)>=100) {
                actions.add(new MakeEvolveAction(this, this.getEvolution()));
            }
        }
        return actions;
    }

    public Action playTurn (ActionList actions, Action lastAction, GameMap map, Display display) {

        turnCount++;

        if(turnCount>=20) {
            boolean otherActorNearby = false;
            for(Exit exit: map.locationOf(this).getExits()){
                if(exit.getDestination().containsAnActor()){
                    otherActorNearby = true;
                    break;
                }
            }
            if (!otherActorNearby) {
                addBehaviour(0, new EvolveBehaviour(this));
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    public void dayEffect() {
        this.heal(10);
    }

    @Override
    public void nightEffect() {
        this.hurt(10);
    }
}
