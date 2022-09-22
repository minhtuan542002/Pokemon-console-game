package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.AttackAction;
import game.Element;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.specialattacks.BackupWeapons;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Charmander extends Pokemon {
    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        backupWeapon = new BackupWeapons(Element.FIRE);
    }


    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
