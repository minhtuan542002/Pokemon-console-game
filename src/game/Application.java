package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.mars.items.MartianItem;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.action.EnterDoorAction;
import game.actors.Nurse;
import game.actors.Player;
import game.actors.Trainer;
import game.affection.AffectionManager;
import game.elements.Element;
import game.environments.*;
import game.items.Candy;
import game.items.Pokeball;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;

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

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Incubator(), new Dirt(), new Wall(),
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
                "........O.................###............................^^",
                "..........................#_#....X...........+............^",
                ".....................+.....................................",
                "...+.......~..............###.###.............W............",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~~~~~~....................................................",
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
                "########___#######");
        GameMap pokeCenter = new GameMap(groundFactory, centerMap);
        world.addGameMap(pokeCenter);

        //Add nurse joy
        Actor nurseCenter = new Nurse();
        pokeCenter.at(9, 2).addActor(nurseCenter);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(27, 6));

        Item candy = new Candy();
        gameMap.at(29,6).addItem(candy);
        gameMap.at(29,6).addItem(candy);
        gameMap.at(29,6).addItem(candy);
        gameMap.at(29,6).addItem(candy);
        gameMap.at(29,6).addItem(candy);
        gameMap.at(29,6).addItem(candy);

        Trainer goh = new Trainer("Goh", 'G', 1);
        gameMap.at(33,4).addActor(goh);
        Actor squirtle = new Squirtle();
        gameMap.at(32,3).addActor(squirtle);
        AffectionManager.getInstance().increaseAffection(goh, squirtle, 100);

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

        MartianItem enterDoor = new MartianItem("Door", '=', false);
        enterDoor.addSampleAction(new EnterDoorAction(pokeCenter.at(9, 5), "to Pokemon Center!"));
        gameMap.at(27, 5).addItem(enterDoor);

        MartianItem exitDoor = new MartianItem("Door", '=', false);
        exitDoor.addSampleAction(new EnterDoorAction(gameMap.at(27, 5), "to Pallet Town!"));
        pokeCenter.at(9, 5).addItem(exitDoor);





        world.run();
    }
}
