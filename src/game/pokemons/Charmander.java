package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
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

    private int turnCount=0;
    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        this.addCapability(Element.DRAGON);
        this.addCapability(Evolution.BASE);
        this.registerInstance();
        backupWeapon.addSpecialWeapon(new FireSpin());
    }


    @Override
    public Pokemon getEvolution() {
        return new Charmeleon();
    }

    public Action playTurn (ActionList actions, Action lastAction, GameMap map, Display display) {

        turnCount++;
        if(AffectionManager.getInstance().getAffectionPoint(this) >=100) {
            this.addBehaviour(0, new EvolveBehaviour(this));
        }
        else {
            this.removeBehaviour(0);
        }
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
