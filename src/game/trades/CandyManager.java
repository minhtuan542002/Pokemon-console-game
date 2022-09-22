package game.trades;

import game.Items.Candy;

import java.util.ArrayList;

// note to self: ask in next consultation if it is still okay to use candy manager
public class CandyManager {

    private static CandyManager instance;

    private ArrayList candies;

    private CandyManager(){}

    public void addCandy(Candy candy){
        this.candies += candy;
    }
}
