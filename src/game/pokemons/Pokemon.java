package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;
import game.time.TimePerception;

abstract class Pokemon extends Actor implements TimePerception  {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Pokemon(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
