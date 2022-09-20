package game.specialattacks;

public class VineWhip extends SpecialWeapon{
    private final int damage = 30;
    private final String verb = "whips";
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
