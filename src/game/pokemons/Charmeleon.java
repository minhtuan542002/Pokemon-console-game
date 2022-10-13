package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.affection.AffectionManager;
import game.behaviours.EvolveBehaviour;
import game.elements.Element;
import game.specialattacks.BackupWeapons;
import game.specialattacks.Blaze;

public class Charmeleon extends Pokemon implements Evolving{
    private int turnCount =0;
    /**
     * Constructor.
     */
    public Charmeleon() {
        super("Charmeleon", 'C', 150);
        backupWeapon.addSpecialWeapon(new Blaze());
    }

    @Override
    public Pokemon getEvolution() {
        return new Charizard();
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
}
