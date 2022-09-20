package game.specialattacks;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.AttackAction;
import game.Element;
import game.pokemons.Pokemon;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 * TODO: Use this class to store Pokemon's weapons (special attack) permanently.
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons {
    static private SpecialWeapon specialWeapon = null;

    public void createSpecialWeapon(Element element) {
        if (specialWeapon == null) {
            if(element ==Element.FIRE) specialWeapon= new Ember();
            if(element ==Element.GRASS) specialWeapon= new VineWhip();
            if(element ==Element.WATER) specialWeapon= new Bubble();
        }
    }
    public Item getSpecialWeapon() {

        return specialWeapon;
    }

    public void equipWeapon(Pokemon pokemon) {

    }
}
