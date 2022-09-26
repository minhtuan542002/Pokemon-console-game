package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.time.TimePerception;

import java.util.List;
import java.util.Random;

public class Puddle extends Ground implements TimePerception {
    private int hasDayEffect;
    private int hasNightEffect;
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
    }

    @Override
    public void dayEffect() {
        int effectRate = new Random().nextInt(100);
        if(effectRate < 10){
            this.hasDayEffect = 1;
        }
    }

    /**
     * Compute the day effect of puddle if it's happend
     *
     * @param location the location of that ground
     */
    public void dayPuddle(Location location){
        if(this.hasDayEffect == 1){
            boolean bool = location.containsAnActor();
            if(!bool){
                Dirt dirt = new Dirt();
                location.setGround(dirt);
            }
        }
    }
    @Override
    public void nightEffect() {
        int effectRate = new Random().nextInt(100);
        if(effectRate < 10){
            this.hasNightEffect = 1;
        }
    }

    /**
     * Compute the night effect of puddle if it's happend
     *
     * @param location the location of that ground
     */
    public void nightPuddle(Location location){
        if(this.hasNightEffect == 1){
            List<Exit> exits = location.getExits();
            for(Exit exit: exits){
                Location exitLocation = exit.getDestination();
                Puddle puddle = new Puddle();
                exitLocation.setGround(puddle);
            }
        }
    }

    @Override
    public void tick(Location location) {
        //this.dayEffect(); manager call it
        this.dayPuddle(location);
        //this.nightEffect();
        this.nightPuddle(location);
    }
}
