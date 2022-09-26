package game.specialattacks;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Special attack weapon
 *
 * Created by:
 * @author Minh Tuan Le
 */
public abstract class SpecialWeapon extends Item implements Weapon {
    /***
     * Constructor.
     *  @param name the name of this Item
     */
    public SpecialWeapon(String name) {
        super(name, 's', false);
    }
}
