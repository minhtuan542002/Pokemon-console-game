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
        this.trainer=trainer;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location trainerLocation = map.locationOf(trainer);
        String inventoryList =(trainer.getInventory().isEmpty()) ?
                "" : trainer.getInventory().get(0).toString();
        inventoryList ="[" +inventoryList;
        for(int i=1; i<trainer.getInventory().size(); i++){

            inventoryList += ", "+ trainer.getInventory().get(i).toString();
        }
        inventoryList+=']';

        String pokemonList ="";
        AffectionManager affectionManager= AffectionManager.getInstance();
        for(Pokemon pokemon: affectionManager.getPokemons()) {
            Location pokemonLocation= map.locationOf(pokemon);
            String pokemonLocationString= (pokemonLocation==null) ? " not on the map": " at "+pokemonLocation.x()+','+pokemonLocation.y();
            pokemonList+=" - "+ pokemon.toString()+ pokemon.printHP()+ " with "+
                    affectionManager.getAffectionPoint(trainer,pokemon)+ " AP"+ pokemonLocationString+ '\n';
        }
        return trainer.toString() +" | "+ trainerLocation.x()+ ','+ trainerLocation.y()+ " | inventory: "+ inventoryList+ '\n'+
                pokemonList;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Check information of "+ trainer;
    }
}
