package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;

import java.util.List;
import java.util.Random;

public class Waterfall extends SpawningGround{
    /**
     * Constructor.
     *
     */
    public Waterfall() {
        super('W');
        this.addCapability(Element.WATER);
    }

    @Override
    public void spawnPokemon(Location location) {
        int waterCount = checkSurrounding(location, Element.WATER);
        int spawnRate = new Random().nextInt(100);
        if(spawnRate < 20 && waterCount >= 2){
            // 10 percent chance
            // check there is actor on that location
            boolean bool = location.containsAnActor();
            if(!bool){
                Squirtle squirtle = new Squirtle();
                location.addActor(squirtle);
            }
        }
    }

    @Override
    public void dropPokeFruit(Location location) {
        int dropRate = new Random().nextInt(100);
        if (dropRate < 20){
            Pokefruit pokefruit = new Pokefruit(Element.WATER);
            location.addItem(pokefruit);
        }

    }
}
