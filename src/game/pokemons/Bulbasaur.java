package game.pokemons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.AttackAction;
import game.Element;
import game.specialattacks.BackupWeapons;

public class Bulbasaur extends Pokemon{
    /**
     * Constructor.
     */
    public Bulbasaur() {
        super("Bulbasaur", 'b', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.GRASS);
        backupWeapon = new BackupWeapons(Element.GRASS);
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
