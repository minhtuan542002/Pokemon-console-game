package game.specialattacks;

public class Bubble extends SpecialWeapon{
    private final int damage = 25;
    private final String verb = "burbles";
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
