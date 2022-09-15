package game.specialattacks;

public class Ember extends SpecialWeapon{
    private final int damage = 20;
    private final String verb = "sparks";
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
