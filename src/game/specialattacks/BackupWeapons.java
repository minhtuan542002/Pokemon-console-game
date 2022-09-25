package game.specialattacks;

import edu.monash.fit2099.engine.actors.Actor;
import game.action.AttackAction;
import game.elements.Element;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Minh Tuan Le
 *
 * TODO: Use this class to store Pokemon's weapons (special attack) permanently.
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons {
    static private SpecialWeapon specialWeapon;

    public BackupWeapons(Element element) {
        if(element ==Element.FIRE) specialWeapon= new Ember();
        else if (element ==Element.GRASS) specialWeapon= new VineWhip();
        else if (element ==Element.WATER) specialWeapon= new Bubble();
    }

    public SpecialWeapon getSpecialWeapon() {
        return specialWeapon;
    }

    public void remove() {
        specialWeapon=null;
    }
}
