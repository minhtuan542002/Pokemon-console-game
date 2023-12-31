package game.pokemons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.elements.Element;
import game.specialattacks.BackupWeapons;
import game.specialattacks.VineWhip;
import game.time.TimePerception;

/**
 * The Pokemon of type Bulbasaur, element is GRASS
 * Created by:
 * @author Minh Tuan Le
 */
public class Bulbasaur extends Pokemon implements TimePerception {
    /**
     * Constructor.
     */
    public Bulbasaur() {
        super("Bulbasaur", 'b', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.GRASS);
        this.addCapability(Evolution.BASE);
        this.registerInstance();
        backupWeapon = new BackupWeapons(new VineWhip());
    }


    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    public void dayEffect() {
        this.hurt(5);
    }

    @Override
    public void nightEffect() {
        this.heal(5);
    }
}
