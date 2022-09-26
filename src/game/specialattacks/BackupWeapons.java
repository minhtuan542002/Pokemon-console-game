package game.specialattacks;

import edu.monash.fit2099.engine.actors.Actor;
import game.action.AttackAction;
import game.elements.Element;

/**
 * The Storage for pokemon's Special attack
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Minh Tuan Le
 *
 * TODO: Use this class to store Pokemon's weapons (special attack) permanently.
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons {
    /**
     * The Special weapon specific to one Pokemon
     */
    static private SpecialWeapon specialWeapon;

    /**
     * Constructor
     *
     * @param element Element attribute of the Special Weapon
     */
    public BackupWeapons(Element element) {
        if(element ==Element.FIRE) specialWeapon= new Ember();
        else if (element ==Element.GRASS) specialWeapon= new VineWhip();
        else if (element ==Element.WATER) specialWeapon= new Bubble();
    }

    /**
     * Get the unique special weapon
     * @return the unique special weapon
     */
    public SpecialWeapon getSpecialWeapon() {
        return specialWeapon;
    }

    /**
     * Free up resource of the object
     */
    public void remove() {
        specialWeapon=null;
    }
}
