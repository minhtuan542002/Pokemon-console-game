package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.affection.AffectionManager;
import game.behaviours.EvolveBehaviour;

/** The interface to handle the evolve action
 *
 */
public interface Evolving{

    public Pokemon getEvolution();

}
