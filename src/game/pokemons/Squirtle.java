package game.pokemons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.elements.Element;
import game.specialattacks.BackupWeapons;

public class Squirtle extends Pokemon{
    /**
     * Constructor.
     */
    public Squirtle() {
        super("Squirtle", 's', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.WATER);
        backupWeapon = new BackupWeapons(Element.WATER);
    }


    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
