package game.pokemons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.elements.Element;
import game.specialattacks.BackupWeapons;
import game.specialattacks.Bubble;

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
