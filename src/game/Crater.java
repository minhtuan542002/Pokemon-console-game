package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crater extends SpawningGround{
    private Ground ground;
    private Location location;
    private List<Charmander> charmanders = new ArrayList<>();


    /**
     * Constructor.
     *
     *
     */
    public Crater() {
        super('O');
    }

    @Override
    public String getSpawningGround() {
        return "Crater";
    }

    @Override
    public void spawnPokemon() {
        var spawnRate = new Random().nextInt(10);
        if(spawnRate < 6){

        }else if (spawnRate < 9){

        }else{
            // 10 percent chance
            Charmander charmander = new Charmander();
            charmanders.add(charmander);
            location.addItem((Item) charmanders);
        }
    }

    @Override
    public void dropPokeFruit() {

    }

    @Override
    public void tick() {
        location.tick();
    }
}
