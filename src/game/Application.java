package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Nurse;
import game.actors.Player;
import game.affection.AffectionManager;
import game.elements.Element;
import game.environments.*;
import game.items.Candy;
import game.items.Pokeball;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(),
                new Lava(), new Puddle());

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "............+..................................+...^^^^^^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "..........................#######........................^^",
                "..........................#_____#............+............^",
                ".....................+....#_____#..........................",
                "...+.......~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~~~~~~....................................................",
                "~~~~~~..+.............................+....................",
                "~~~~~~~~~..................................................");
        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(32, 10));

        //Add first pokemon - Charmander
        Actor charmander = new Charmander();
        gameMap.at(33, 10).addActor(charmander);
        Actor bulbasaur = new Bulbasaur();
        gameMap.at(33,11).addActor(bulbasaur);

        AffectionManager.getInstance().increaseAffection(bulbasaur, 200);

        ash.addItemToInventory(new Pokefruit(Element.FIRE));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));


        // add nurse joy
        Actor nurse = new Nurse("Nurse Joy", '%', 1);
        gameMap.at(29, 6).addActor(nurse);

        // throw a candy to test if it works
        // Item candy = new Candy();
        gameMap.at(32, 11).addItem(new Candy());
        world.run();


    }
}
