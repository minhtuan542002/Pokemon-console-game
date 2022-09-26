package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Charmander;

import java.util.Random;

public class Crater extends SpawningGround {



    /**
     * Constructor.
     *
     */
    public Crater() {
        super('O');
        this.addCapability(Element.FIRE);

    }



    @Override
    public void spawnPokemon(Location location) {
        int spawnRate = new Random().nextInt(100);
        if(spawnRate < 10){
            // 10 percent chance
            // check there is actor on that location
            boolean bool = location.containsAnActor();
            if(!bool){
                Charmander charmander = new Charmander();
                location.addActor(charmander);
            }
        }
    }

    @Override
    public void dropPokeFruit(Location location) {
        int dropRate = new Random().nextInt(100);
        if (dropRate < 25){
            Pokefruit pokefruit = new Pokefruit(Element.FIRE);
            location.addItem(pokefruit);
        }

    }

}
