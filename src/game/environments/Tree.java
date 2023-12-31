package game.environments;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Candy;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.pokemons.Squirtle;
import game.time.TimePerception;

import java.util.List;
import java.util.Random;

public class Tree extends SpawningGround implements TimePerception, Expendable, Destoryable {
    private int hasDayEffect;
    private int hasNightEffect;

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
        this.addCapability(Element.GRASS);
        this.registerInstance();
    }


    @Override
    public void spawnPokemon(Location location) {
        int grassCount = checkSurrounding(location, Element.GRASS);
        int spawnRate = new Random().nextInt(100);
        if(spawnRate < 15 && grassCount >= 1){
            // 10 percent chance
            // check there is actor on that location
            boolean bool = location.containsAnActor();
            if(!bool){
                Bulbasaur bulbasaur = new Bulbasaur();
                location.addActor(bulbasaur);
            }
        }

    }

    @Override
    public void dropPokeFruit(Location location) {
        int dropRate = new Random().nextInt(100);
        if (dropRate < 15){
            Pokefruit pokefruit = new Pokefruit(Element.GRASS);
            location.addItem(pokefruit);
        }

    }

    @Override
    public void dayEffect() {
        int effectRate = new Random().nextInt(100);
        if(effectRate < 5){
            this.hasDayEffect = 1;
        }
    }

    /**
     * Compute the day effect of tree if it's happend
     *
     * @param location the location of that ground
     */
    public void dayTree(Location location){
        if(this.hasDayEffect == 1){
            Candy candy = new Candy();
            location.addItem(candy);
        }
    }

    @Override
    public void nightEffect() {
        int effectRate = new Random().nextInt(100);
        if(effectRate < 10){
            this.hasNightEffect = 1;
        }

    }

    /**
     * Compute the night effect of lava if it's happend
     *
     * @param location the location of that ground
     */
    public void nightTree(Location location){
        if(this.hasNightEffect == 1){
            int groundRate = new Random().nextInt(100);
            if(groundRate < 50){
                Tree tree = new Tree();
                expend(location,tree);
            }else{
                Hay hay = new Hay();
                expend(location,hay);
                }
            }
        }
    @Override
    public void tick(Location location) {
        //this.dayEffect(); manager call it
        this.dayTree(location);
        //this.nightEffect();
        this.nightTree(location);
        this.spawnPokemon(location);
        this.dropPokeFruit(location);
    }
}
