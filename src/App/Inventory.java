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
     * adds the target object to the inventory array.
     * @param item 
     */
    public void add(Iitem item){
        inventory.add(item);
    }
    
    /**
     * Prints out the inventory array.
     */
    public void show(){
        System.out.println("\n------------INVENTORY------------");
        for (int i=0; i < inventory.size();i++) {
                System.out.print(inventory.get(i)+"\n");
            }
    }
    
    /**
     * When given objects name as a string, this method moves the targeted object
     * from the room loot array to the players inventory array
     * @param item
     * @return temp
     */
      public Iitem MoveFromInventoryToRoom(String item){
        Iitem temp;
        for (int i = 0; i<inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(item)) {
                temp = this.inventory.get(i);
                System.out.println("\nYOU DROPPED: "+inventory.get(i).toString()+"\n");
                this.inventory.remove(i);
                            
                return temp;
            }
        }return null;
        
    
    }
  
    
    
}
