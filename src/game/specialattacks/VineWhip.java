package game.specialattacks;

/**
 * Special attack for Bulbasaur
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class VineWhip extends SpecialWeapon{
    /**
     * The damage of the attack
     */
    private final int damage = 30;

    /**
     * The verb for the attack
     */
    private final String verb = "whips";

    /**
     * hitRate for the attack to succeed
     */
    private final int hitRate = 70;
    /***
     * Constructor.
     */
    public VineWhip() {
        super("Vine Whip");
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
