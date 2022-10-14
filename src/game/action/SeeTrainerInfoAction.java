package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.affection.AffectionManager;
import game.pokemons.Pokemon;

public class SeeTrainerInfoAction extends Action {
    Actor trainer;

    public SeeTrainerInfoAction(Actor trainer) {

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location trainerLocation = map.locationOf(trainer);
        StringBuilder inventoryList = new StringBuilder("[" + trainer.getInventory().get(0).toString());
        for(int i=1; i<trainer.getInventory().size(); i++){

            inventoryList.append(", ").append(trainer.getInventory().get(i).toString());
        }
        inventoryList.append(']');

        StringBuilder pokemonList = new StringBuilder();
        AffectionManager affectionManager= AffectionManager.getInstance();
        for(Pokemon pokemon: affectionManager.getPokemons()) {
            Location pokemonLocation= map.locationOf(pokemon);
            pokemonList.append(" - ").append(pokemon.toString()).append(pokemon.printHP()).append(" with ").append(affectionManager.getAffectionPoint(trainer, pokemon)).append(" AP at ").append(pokemonLocation.x()).append(',').append(pokemonLocation.y()).append('\n');
        }
        return trainer.toString() +" | "+ trainerLocation.x()+ ','+ trainerLocation.y()+ " | inventory: "+ inventoryList+ '\n'+
                pokemonList;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Check information of "+ trainer;
    }
}
