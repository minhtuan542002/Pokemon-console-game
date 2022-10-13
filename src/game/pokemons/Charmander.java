package game.pokemons;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.elements.Element;
import game.specialattacks.BackupWeapons;
import game.specialattacks.Ember;
import game.time.TimePerception;

/**
 * Pokemon Charmander
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Minh Tuan Le
 */
public class Charmander extends Pokemon implements TimePerception {
    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        this.addCapability(Evolution.BASE);
        this.registerInstance();
        backupWeapon = new BackupWeapons(new Ember());
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
