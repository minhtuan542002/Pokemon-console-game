package game.pokemons;

import game.specialattacks.BackupWeapons;
import game.specialattacks.Ember;

public class Charizard extends Pokemon{
    /**
     * Constructor.
     */
    public Charizard() {
        super("Charizard", 'Z', 200);
        backupWeapon = new BackupWeapons(new Ember());
    }

}
