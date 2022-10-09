package game.specialattacks;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.elements.Element;

import java.util.ArrayList;
import java.util.List;

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
    static private List<WeaponItem> specialWeapons = new ArrayList<>();

    /**
     * Constructor
     *
     * @param weaponItems the special weapons tobe stored in the Pokemon
     */
    public BackupWeapons(WeaponItem... weaponItems) {
        specialWeapons.addAll(List.of(weaponItems));
    }

    /**
     * Get the list of special weapons
     * @return the list of special weapons
     */
    public List<WeaponItem> getSpecialWeapon() {
        return specialWeapons;
    }

    /**
     * Free up resource of the object
     */
    public void remove() {
        specialWeapons=null;
    }
}
