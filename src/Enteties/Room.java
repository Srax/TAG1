package Enteties;

import Boundry.Boundry;
import MonsterTypes.Monster;
import items.Iitem;
import java.util.ArrayList;

public class Room {

    private int gold;
    private String description;
    private Room north = null;
    private Room south = null;
    private Room west = null;
    private Room east = null;
    private int taxCollector;
    private int trap;
    private int lockedDoorNorth;////////////////////////
    private Monster monster=null;
    
    ArrayList<Iitem> loot = new ArrayList<>();

    public void add(Iitem item) {
        loot.add(item);
    }

    public Room(int gold, String Description) {
        this.gold = gold;
        this.description = Description;
    }
    public Room(String Description) {
        this.description = Description;
    }

    public Room() {
    }

    public Iitem moveFromRoomToInventory(String item) {
        Iitem temp;
      
        for (int i = 0; i < loot.size(); i++) {
            if (loot.get(i).getName().equalsIgnoreCase(item)) {
                temp = loot.get(i);
                this.loot.remove(i);
                
            return temp;
        }
    }return null;
    }
 
    public void showLoot() {
        for (int i = 0; i < loot.size(); i++) {
            System.out.println(loot.get(i));
        }
    }

    public Monster getMonster() {
        return monster;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getTrap() {
        return trap;
    }
    public void setTrap(int trap) {
        this.trap = trap;
    }

    public int getTaxCollector() {
        return taxCollector;
    }
    public void setTaxCollector(int taxCollector) {
        this.taxCollector = taxCollector;
        if (taxCollector > 0) {
            this.setGold(0);
        }
    }

    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setMonsterGold(int gold){
        this.gold += gold;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String Description) {
        this.description = Description;
    }

    public Room getNorth() {////////////////////////////////////////////77
        if(this.lockedDoorNorth > 0){
            return null;
        }else 
        return north;
    }
    public void setNorth(Room North) {
        this.north = North;
    }
    public void lockedDoorNorth(int lock){
        this.lockedDoorNorth = lock;
    }///////////////////////
    public int getLockedDoorNorth(){
        return lockedDoorNorth;
    }/////////////////////////
    
    public Room getSouth() {
        return south;
    }
    public void setSouth(Room South) {
        this.south = South;
    }

    public Room getWest() {
        return west;
    }
    public void setWest(Room West) {
        this.west = West;
    }

    public Room getEast() {
        return east;
    }
    public void setEast(Room East) {
        this.east = East;
    }

    public void availableDirections() {
        Boundry b = new Boundry();
        b.canGo();
        if (getNorth() != null) {
            System.out.println(" North");
        }

        if (getSouth() != null) {
            System.out.println(" South");
        }

        if (getWest() != null) {
            System.out.println(" West");
        }

        if (getEast() != null) {
            System.out.println(" East");
        }
    }

    @Override
    public String toString() {

        return description;

    }

}