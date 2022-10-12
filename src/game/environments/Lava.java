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
public class Lava extends Ground implements TimePerception, Expendable, Destoryable {
    private int hasDayEffect;
    private int hasNightEffect;

    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
        this.registerInstance();
    }

    @Override
    public void dayEffect() {
        int effectRate = new Random().nextInt(100);
        if(effectRate < 10){
            this.hasDayEffect = 1;
        }

    }
    /**
     * Compute the day effect of lava if it's happend
     *
     * @param location the location of that ground
     */
    public void dayLava(Location location){
        if(this.hasDayEffect == 1){
            Lava lava = new Lava();
            expend(location, lava);
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
     * Compute the night effect of lava if it's happend
     *
     * @param location the location of that ground
     */
    public void nightLava(Location location){
        if(this.hasNightEffect == 1){
            destory(location);
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

