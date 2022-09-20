package game.Actions;

import game.Items.Candy;

import java.util.ArrayList;

public class CandyManager {

    private static CandyManager instance;

    private ArrayList candies;

    private CandyManager(){}

    public void addCandy(Candy candy){
        this.candies += candy;
    }
}
