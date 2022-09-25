package game.affection;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;
import game.behaviours.FollowBehaviour;
import game.pokemons.Charmander;
import game.pokemons.Pokemon;

import java.util.HashMap;
import java.util.Map;

/**
 * Affection Manager
 * <p> Self initiated and single instance class to manage Pokemon affection level and update their
 * Capability, allowable actions and behaviours accordingly. </p>
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Minh Tuan Le
 */
public class AffectionManager {

    /**
     * Singleton instance (the one and only for a whole game).
     */
    private static AffectionManager instance;
    /**
     * HINT: is it just for a Charmander?
     */
    private final Map<Pokemon, Integer> affectionPoints;

    /**
     * We assume there's only one trainer in this manager.
     * Think about how will you extend it.
     */
    private Actor trainer;

    /**
     * private singleton constructor
     */
    private AffectionManager() {
        this.affectionPoints = new HashMap<>();
    }

    /**
     * Access single instance publicly
     *
     * @return this instance
     */
    public static AffectionManager getInstance() {
        if (instance == null) {
            instance = new AffectionManager();
        }
        return instance;
    }

    /**
     * Add a trainer to this class's attribute. Assume there's only one trainer at a time.
     *
     * @param trainer the actor instance
     */
    public void registerTrainer(Actor trainer) {
        this.trainer = trainer;
    }

    /**
     * Add Pokemon to the collection. By default, it has 0 affection point.
     * Ideally, you'll register all instantiated Pokemon
     *
     * @param pokemon
     */
    public void registerPokemon(Pokemon pokemon) {
        affectionPoints.put(pokemon,0);
    }

    /**
     * Get the affection point by using the pokemon instance as the key.
     *
     * @param pokemon Pokemon instance
     * @return integer of affection point.
     */
    public int getAffectionPoint(Pokemon pokemon) {
        return affectionPoints.get(pokemon);
    }

    /**
     * Useful method to search a pokemon by using Actor instance.
     *
     * @param actor general actor instance
     * @return the Pokemon instance.
     */
    private Pokemon findPokemon(Actor actor) {
        for (Pokemon pokemon : affectionPoints.keySet()) {
            if (pokemon.equals(actor)) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Increase the affection. Work on both cases when there's a Pokemon,
     * or when it doesn't exist in the collection.
     *
     * @param actor Actor instance, but we expect a Pokemon here.
     * @param point positive affection modifier
     * @return custom message to be printed by Display instance later.
     */
    public String increaseAffection(Actor actor, int point) {
        return "";
    }

    /**
     * Decrease the affection level of the . Work on both cases when it is
     *
     * @param actor Actor instance, but we expect a Pokemon here.
     * @param point positive affection modifier (to be subtracted later)
     * @return custom message to be printed by Display instance later.
     */
    public String decreaseAffection(Actor actor, int point) {
        return "";
    }

    public void updatePokemonBehaviours() {
        for(Map.Entry<Pokemon, Integer> entry : affectionPoints.entrySet()) {
            if(entry.getValue()>=75) {
                entry.getKey().addBehaviour(1, new FollowBehaviour(trainer));
            }
            if(entry.getValue()<=-50) {
                entry.getKey().addCapability(Status.HOSTILE);
            }
            if(entry.getValue()>=50) {
                entry.getKey().addCapability(Status.CATCHABLE);
            }
        }
    }

    public void removePokemon(Pokemon pokemon) {
        affectionPoints.remove(pokemon);
    }

    public String printAffectionPoint(Pokemon pokemon) {
        return "(AP: " + getAffectionPoint(pokemon) + ")";
    }

}
