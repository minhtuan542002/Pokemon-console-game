package game.affection;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;
import game.behaviours.FollowBehaviour;
import game.pokemons.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;

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
    private Map<Actor, Map<Pokemon, Integer>> affectionPoints;

    /**
     * The list of trainers
     */
    private List<Actor> trainers = new ArrayList<>();

    private List<Pokemon> pokemons = new ArrayList<>();

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

    public List<Actor> getTrainers() {
        return trainers;
    }
    public List<Pokemon> getPokemons() { return pokemons;}

    /**
     * Add a trainer to this class's attribute. Assume there's only one trainer at a time.
     *
     * @param trainer the actor instance
     */
    public void registerTrainer(Actor trainer) {
        this.trainers.add(trainer);
        if(!pokemons.isEmpty()){
            for (Pokemon pokemon: pokemons) {
                HashMap<Pokemon, Integer> acctyp = new HashMap<>();
                acctyp.put(pokemon, 0);
                affectionPoints.put(trainer, acctyp);
            }
        }
    }

    /**
     * Add Pokemon to the collection. By default, it has 0 affection point.
     * Ideally, you'll register all instantiated Pokemon
     *
     * @param pokemon The Pokemon to be registered
     */
    public void registerPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        if(!trainers.isEmpty()) {
            if(affectionPoints.isEmpty()){
                for (Actor trainer : trainers) {
                    HashMap<Pokemon, Integer> acctyp = new HashMap<Pokemon, Integer>();
                    acctyp.put(pokemon, 0);
                    affectionPoints.put(trainer, acctyp);
                }
            }
            for (Actor trainer : trainers) {
                HashMap<Pokemon, Integer> acctyp = new HashMap<Pokemon, Integer>();
                acctyp.put(pokemon, 0);
                affectionPoints.get(trainer).put(pokemon, 0);
            }
        }
    }

    /**
     * Get the affection point by using the pokemon instance as the key.
     *
     * @param trainer Trainer instance
     * @param pokemon Pokemon instance
     * @return integer of affection point.
     */
    public int getAffectionPoint(Actor trainer, Actor pokemon) {
        return affectionPoints.get(trainer).get(findPokemon(pokemon));
    }

    /**
     * Useful method to search a pokemon by using Actor instance.
     *
     * @param actor general actor instance
     * @return the Pokemon instance.
     */
    public Pokemon findPokemon(Actor actor) {
        for (Pokemon pokemon : pokemons) {
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
     * @param pokemon Actor instance, but we expect a Pokemon here.
     * @param trainer The trainer of the pokemon
     * @param point positive affection modifier
     * @return custom message to be printed by Display instance later.
     */
    public String increaseAffection(Actor trainer, Actor pokemon, int point) {
        Pokemon target = findPokemon(pokemon);
        affectionPoints.get(trainer).put(target, min(100,affectionPoints.get(trainer).get(target) + point));
        return affectionPoints.get(trainer).get(target).toString();
    }

    /**
     * Decrease the affection level of the . Work on both cases when it is
     *
     * @param pokemon Actor instance, but we expect a Pokemon here.
     * @param trainer The trainer of the pokemon
     * @param point positive affection modifier
     * @return custom message to be printed by Display instance later.
     */
    public String decreaseAffection(Actor trainer, Actor pokemon, int point) {
        Pokemon target = findPokemon(pokemon);
        affectionPoints.get(trainer).put(target, max(-100,affectionPoints.get(trainer).get(target) - point));
        return affectionPoints.get(trainer).get(target).toString();
    }

    /**
     * Update the behaviours of the Pokemons according to the Affection points
     */
    public void updatePokemonBehaviours() {
        for(Actor trainer: trainers) {
            for (Map.Entry<Pokemon, Integer> entry : affectionPoints.get(trainer).entrySet()) {
                if (entry.getValue() >= 75) {
                    entry.getKey().addBehaviour(1, new FollowBehaviour(trainer));
                } else {
                    entry.getKey().removeBehaviour(1);
                }
                if (entry.getValue() <= -50) {
                    entry.getKey().addCapability(Status.HOSTILE);
                } else {
                    entry.getKey().hasCapability(Status.CAN_CONSUME_POKEFRUIT);
                }
                if (entry.getValue() >= 50) {
                    entry.getKey().addCapability(Status.CATCHABLE);
                } else {
                    entry.getKey().removeCapability(Status.CATCHABLE);
                }

            }
        }
    }

    /**
     * Remove a Pokemon from the Affection manager to free up resource
     * @param actor the Pokemon to be removed from Affection Manager
     */
    public void removePokemon(Actor actor) {
        Pokemon pokemon= findPokemon(actor);
        for(Actor trainer: trainers) {
            affectionPoints.get(trainer).remove(pokemon);
        }
        pokemons.remove(pokemon);
    }

    /**
     * Print the Pokemon name, health and Affection point
     * @param trainer the trainer of the pokemon
     * @param poke the pokemon that need the affection point to be reported
     * @return Pokemon information in the format of [Pokemon's name](current HP/max HP)(AP:Affection point)
     */
    public String printAffectionPoint(Actor trainer, Actor poke) {
        Pokemon pokemon = findPokemon(poke);
        return pokemon+ pokemon.printHP() +"(AP: " + getAffectionPoint(trainer, pokemon) + ")";
    }

    /**
     * Print all the affection points corresponding to all trainers and pokemons in affection managers.
     * Used only for testing purposes
     */
    public void print() {
        System.out.println("\n all");
        for (Actor trainer: affectionPoints.keySet()) {
            System.out.println(" "+trainer.toString());
            if(affectionPoints.get(trainer)==null) {
                System.out.println("null");
                return;
            }
            for (Pokemon pokemon: affectionPoints.get(trainer).keySet()) {
                System.out.println("   "+pokemon.toString()+"/"+affectionPoints.get(trainer).get(pokemon).toString());
            }
        }
    }
}
