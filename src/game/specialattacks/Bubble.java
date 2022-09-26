package game.specialattacks;

/**
 * Special attack for Squirtle
 *
 * Created by:
 * @author Minh Tuan Le
 */
public class Bubble extends SpecialWeapon{
    /**
     * The damage of the attack
     */
    private final int damage = 25;

    /**
     * The verb for the attack
     */
    private final String verb = "burbles";

    /**
     * hitRate for the attack to succeed
     */
    private final int hitRate = 80;

    /***
     * Constructor.
     */
    public Bubble() {
        super("Bubble");
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
