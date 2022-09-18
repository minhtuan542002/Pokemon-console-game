package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Candy;

import java.util.ArrayList;

public class TradeAction extends Action {

    private ArrayList<game.Items.Candy> candy = new ArrayList<game.Items.Candy>();

    // TradeAction attributes


    // constructor
    public TradeAction() {
        this.candy = new ArrayList<Candy>();
    }

    // methods
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    // method to delete candy
    public void deductCandy(int candy) {
        Candy.add("candy")
    }

    // method to add candy
    public void addCandy(int candy) {
        candy = candy + 1;
    }


    // getters and setters for Candy
    public ArrayList<Candy> getCandy() {
        return candy;
    }

    public void setCandy(ArrayList<Candy> candy) {
        this.candy = candy;
    }
}


/**
 *     make a list of no. of candies
 *
 *     public void addCandy([] ]){
 *         this.candyAmount.append ???;
 *     }
 *
 *     public void removeCandy(){
 *         this.candyAmount.pop ???;
 *     }
 *
 *     public int getCandyList(){
 *         return candyAmount;
 *     }
 */