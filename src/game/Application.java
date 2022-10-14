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
//import game.actors.AffectionManager;
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
                new Waterfall(), new Hay(),
                new Crater(), new Door(),
                new Lava(), new Puddle());
                new Incubator();

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "............+..................................+...^^^^^^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "........O.................#######........................^^",
                "..........................#_____#............+............^",
                ".....................+....#_____#..........................",
                "...+.......~..............###_###.............W............",
                "...~~~~~~~~................................................",
                "....~~~~~..................###.............................",
                "~~~~~~~....................#=#.............................",
                "~~~~~~..+.............................+....................",
                "~~~~~~~~~..................................................");
        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        List<String> centerMap = Arrays.asList(
                "##################",
                "#________________#",
                "#______.._.._____#",
                "#________________#",
                "#________________#",
                "########_=_#######");
        GameMap pokeCenterMap = new GameMap(groundFactory, centerMap);
        world.addGameMap(pokeCenterMap);

        //Add nurse joy
        Actor nurseCenter = new Nurse();
        pokeCenterMap.at(9, 2).addActor(nurseCenter);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(32, 10));

        //Add first pokemon - Charmander
        Actor charmander = new Charmander();
        gameMap.at(33, 10).addActor(charmander);
        Actor bulbasaur = new Bulbasaur();
        gameMap.at(33,11).addActor(bulbasaur);

        ash.addItemToInventory(new Pokefruit(Element.FIRE));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));
        ash.addItemToInventory(new Pokefruit(Element.GRASS));

        Lava lava = new Lava();
        gameMap.at(13,4).setGround(lava);


        // add nurse joy
        Actor nurse = new Nurse();
        gameMap.at(29, 6).addActor(nurse);


        world.run();
    }
}
