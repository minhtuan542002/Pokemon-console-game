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

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));

        return actions;
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
