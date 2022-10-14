package game.pokemons;

import game.specialattacks.BackupWeapons;
import game.specialattacks.Ember;
import game.specialattacks.FireSpin;

public class Charizard extends Pokemon{
    /**
     * Constructor.
     */
    public Charizard() {
        super("Charizard", 'Z', 200);
        backupWeapon.addSpecialWeapon(new FireSpin());
    }

}
