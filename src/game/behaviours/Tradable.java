package game.behaviours;

public interface Tradable {

    // add methods that tradable items can implement (IMPORTANT NOte - should not have a body for methods

    // tradable items should give me thier cost price of Item
    public void getItemCost();  // method 1

    // whichever item is traded should be added to player's inventory
    public void addToPlayerInventory();     // method 2
}
