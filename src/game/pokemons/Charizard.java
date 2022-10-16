package game.pokemons;

import game.elements.Element;
import game.specialattacks.BackupWeapons;
import game.specialattacks.Ember;
import game.specialattacks.FireSpin;

/**
 * The Pokemon of type Charizard, the evolution of Charmeleon, type Dragon and fire
 * Created by:
 * @author Minh Tuan Le
 */
public class Charizard extends Pokemon{
    /**
     * Constructor.
     */
    public Charizard() {
        super("Charizard", 'Z', 200);
        backupWeapon.addSpecialWeapon(new FireSpin());
        this.addCapability(Element.FIRE);
        this.addCapability(Element.DRAGON);

    }

}
