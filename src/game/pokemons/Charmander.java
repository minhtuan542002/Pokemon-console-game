package game.pokemons;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.elements.Element;
import game.specialattacks.BackupWeapons;

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
        this.removeCapability(Status.CATCHABLE);
        backupWeapon = new BackupWeapons(Element.FIRE);
    }


    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    public void dayEffect() {
        this.heal(10);
    }

    @Override
    public void nightEffect() {
        this.hurt(10);
    }
}
