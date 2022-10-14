package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

public class Door extends Ground {
    public Door() {
        super('=');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return true;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
