package game.specialattacks;

/**
 * Special attack for Charmander
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class Ember extends SpecialWeapon{
    /**
     * The damage of the attack
     */
    private final int damage = 20;

    /**
     * The verb for the attack
     */
    private final String verb = "sparks";

    /**
     * hitRate for the attack to succeed
     */
    private final int hitRate = 90;

    /***
     * Constructor.
     */
    public Ember() {
        super("Ember");
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String verb() {
        return verb;
    }

    @Override
    public int chanceToHit() {
        return hitRate;
    }
}
