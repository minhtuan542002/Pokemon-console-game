package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Lava extends Ground {
    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
    }
}
