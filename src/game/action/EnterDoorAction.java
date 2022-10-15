package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class EnterDoorAction extends Action {
    /**
     * Target location
     */
    protected Location moveToLocation;
    /**
     * One of the 8-d navigation
     */
    protected String direction;
    public EnterDoorAction(Location moveToLocation, String direction) {
        this.moveToLocation = moveToLocation;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, moveToLocation);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters " + direction;
    }
}
