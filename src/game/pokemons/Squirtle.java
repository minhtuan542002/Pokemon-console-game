package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.AttackAction;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.specialattacks.BackupWeapons;
import game.specialattacks.Bubble;

import java.util.ArrayList;
import java.util.List;

/**
 * Pokemon Squirtle
 * Created by:
 *
 * @author Minh Tuan Le
 */
public class Squirtle extends Pokemon{
    /**
     * Constructor.
     */
    public Squirtle() {
        super("Squirtle", 's', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.WATER);
        backupWeapon = new BackupWeapons(new Bubble());
    }

    @Override
    public Action playTurn (ActionList actions, Action lastAction, GameMap map, Display display) {

        Actor targetedActor = null;
        for (Exit exit : map.locationOf(this).getExits()) {
            targetedActor = map.getActorAt(exit.getDestination());
            toggleWeapon((targetedActor != null) && (targetedActor.findCapabilitiesByType(Element.class).contains(Element.FIRE)));
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    public void dayEffect() {
        this.hurt(10);
    }

    @Override
    public void nightEffect() {
        this.heal(10);
    }
}
