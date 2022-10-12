package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.pokemons.PokemonEgg;
import game.pokemons.Squirtle;

public class Incubator extends Ground {

    /**
     * private integer for hashTime representing number of turns taken by pokemon egg to hatch
     */
    private int hatchTime;

    /**
     * Constructor.
     *
     */
    public Incubator() { super( 'X'); }



    public void tick(Location location) {
        hatchTime ++;
        if (hatchTime == 2 && ) {
            location.addActor(new Squirtle());
        }
        if (hatchTime == 3) {
            if (location.containsAnActor()){
                for (Exit exits: location.getExits()){

                    if (!exits.getDestination().containsAnActor()){
                        exits.getDestination().addActor(new Bulbasaur());
                        break;
                    }
                }
            }else{
                location.addActor(new Bulbasaur()); // for bulbasaur
            }
//
        }
        if (hatchTime == 4) {
            location.addActor(new Charmander()); // for charmander
        }

    }
}
