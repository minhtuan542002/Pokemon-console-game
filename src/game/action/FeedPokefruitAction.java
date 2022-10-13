package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.AffectionManager;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.items.Pokefruit;

/**
 * An action to feed the Pokefruit to a Pokemon
 * Created by:
 *
 * @author Minh Tuan Le
 */
public class FeedPokefruitAction extends Action {
    /**
     * The Pokemon to be fed
     */
    private Actor pokemon;

    /**
     * The Pokefruit fed to the pokemon
     */
    private Pokefruit pokefruit;

    /**
     * Constructor
     * @param pokemon The Pokemon to be fed
     * @param pokefruit The Pokefruit fed to the pokemon
     */
    public FeedPokefruitAction(Actor pokemon, Pokefruit pokefruit) {
        this.pokefruit=pokefruit;
        this.pokemon=pokemon;
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
        return resultMessage;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Ash gives " + pokefruit + " to " + AffectionManager.getInstance().printAffectionPoint(pokemon);
    }
}
