package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.affection.AffectionManager;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.items.Pokefruit;
import game.pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class FeedPokefruitAction extends Action {
    private Pokemon pokemon;

    private Pokefruit pokefruit;

    public FeedPokefruitAction(Pokemon pokemon, Pokefruit pokefruit) {

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        ElementsHelper elementsHelper = new ElementsHelper();
        String resultMessage = "";

        if (elementsHelper.hasAnySimilarElements(pokemon, pokefruit.findCapabilitiesByType(Element.class))) {
            AffectionManager.getInstance().increaseAffection(pokemon, 20);
            resultMessage = pokemon+ " likes it! +20 affection points";
        }
        else {
           AffectionManager.getInstance().decreaseAffection(pokemon, 10);
           resultMessage = pokemon+" dislikes it! -10 affection points";
        }
        actor.removeItemFromInventory(pokefruit);
        pokefruit.remove();
        return resultMessage;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Ash gives " + pokefruit + " to " + pokemon +
                pokemon.printHP() + AffectionManager.getInstance().printAffectionPoint(pokemon);
    }
}
