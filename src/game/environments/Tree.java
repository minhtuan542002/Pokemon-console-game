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

public class Tree extends SpawningGround implements TimePerception {
    private int hasDayEffect;
    private int hasNightEffect;

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
        this.addCapability(Element.GRASS);
    }


    @Override
    public void spawnPokemon(Location location) {
        List<Exit> exits = location.getExits();
        int grassCount = 0;
        Ground tree = new Tree();
        Ground hay = new Hay();
        for(Exit exit: exits){
            Location exitLocation = exit.getDestination();
            if(exitLocation.getGround() == tree ||exitLocation.getGround() == hay){
                grassCount += 1;
            }
        }
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

    public void nightTree(Location location){
        if(this.hasNightEffect == 1){
            List<Exit> exits = location.getExits();
            int groundRate = new Random().nextInt(100);
            if(groundRate < 50){
                for(Exit exit: exits){
                    Location exitLocation = exit.getDestination();
                    Tree tree = new Tree();
                    exitLocation.setGround(tree);
                }
            }else{
                for(Exit exit: exits){
                    Location exitLocation = exit.getDestination();
                    Hay hay = new Hay();
                    exitLocation.setGround(hay);
                }
            }
        }
    }
    @Override
    public void tick(Location location) {
        //this.dayEffect(); manager call it
        this.dayTree(location);
        //this.nightEffect();
        this.nightTree(location);
    }
}
