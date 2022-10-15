package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.MakeEvolveAction;
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
//        backupWeapon.addSpecialWeapon(new Blaze());
    }

    @Override
    public Pokemon getEvolution() {
        return new Charizard();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions= super.allowableActions(otherActor, direction, map);
        AffectionManager affectionManager=AffectionManager.getInstance();
        if(affectionManager.getTrainers().contains(otherActor)) {
            if (affectionManager.getAffectionPoint(otherActor, this) >= 100) {
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
}
