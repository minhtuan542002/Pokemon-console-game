package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.environments.Dirt;
import game.time.TimePerception;

import java.util.List;
import java.util.Random;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Zhijun Chen
 */
public class Lava extends Ground implements TimePerception {
    private int hasDayEffect;
    private int hasNightEffect;
    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
    }

    @Override
    public void dayEffect() {
        int effectRate = new Random().nextInt(100);
        if(effectRate < 10){
            this.hasDayEffect = 1;
        }

    }
    public void dayLava(Location location){
        if(this.hasDayEffect == 1){
            List<Exit> exits = location.getExits();
            for(Exit exit: exits){
                Location exitLocation = exit.getDestination();
                Lava lava = new Lava();
                exitLocation.setGround(lava);
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

    public void nightLava(Location location){
        if(this.hasNightEffect == 1){
            boolean bool = location.containsAnActor();
            if(!bool){
                Dirt dirt = new Dirt();
                location.setGround(dirt);
            }
        }
    }

    @Override
    public void tick(Location location) {
        //this.dayEffect(); manager call it
        this.dayLava(location);
        //this.nightEffect();
        this.nightLava(location);
    }
}

