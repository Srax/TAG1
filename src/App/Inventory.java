/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import items.Iitem;
import java.util.ArrayList;

/**
 *
 * @author Stanislav
 */
public class Inventory {

    ArrayList<Iitem> inventory = new ArrayList<>();

    /**
     * Adds the target object to the inventory array.
     *
     * @param item
     */
    public void add(Iitem item) {
        inventory.add(item);
    }

    /**
     * Prints out the inventory array.
     */
    public void show() {
        System.out.println("\n------------INVENTORY------------");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print(inventory.get(i) + "\n");
        }
    }

    /**
     * When given objects name as a string, this method moves the targeted
     * object from the room loot array to the players inventory array
     *
     * @param item
     * @return temp
     */
    public Iitem MoveFromInventoryToRoom(String item) {
        Boundry b = new Boundry();
        Iitem temp;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(item)) {
                temp = this.inventory.get(i);
                b.youDropped(inventory.get(i).toString());

                this.inventory.remove(i);

                return temp;
            }
        }
        return null;

    }
    /**
 * Checks if the item exist in the Inventory Array, thereafter checks if the item
 * is usable. If usable it runs the use() method in the item, then it removes item
 * from the Inventory.
 * @param item
 * @param player 
 */
    public void use(String item, Player player) {
        Boundry b = new Boundry();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(item)) {
                this.inventory.get(i);

                if (this.inventory.get(i).getUsable() == true) {
                    this.inventory.get(i).use(player);
                    b.youUsed(inventory.get(i).toString());

                    this.inventory.remove(i);

                } else {
                    b.youCannotUseItem();
                }
            } else {
                b.nothingHappend();
            }
        }

    }

}
