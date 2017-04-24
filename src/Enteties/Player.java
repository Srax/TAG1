package Enteties;

import Boundry.Boundry;
import items.Armor;
import items.Iitem;
import items.Weapon;
import java.util.ArrayList;

public class Player {

    //Players position, and last position
    private Room currentRoom = null;
    private Room lastRoom = null;

    //Player Stats
    private String name = "Guest";
    private int dmg = 1, bank, def = 0;
    private int hp = 100;

    //Plyer inventory and management
    private ArrayList<Iitem> inventory = new ArrayList<>();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player() {
    }

    //Getters & Setters    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

    public Room getLastRoom() {
        return lastRoom;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;

    }

    public int getDmg() {
        return dmg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    //If the players HP goes below 0, set hp to 0 so that it won't display minus.
    public void setHp(int hp) {
        this.hp += hp;
        if (this.hp > 100) {
            this.hp = 100;
        } else if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {

        this.bank += bank;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return "=============================================================================="
                + "\nPlayer: " + name + "\nHP: " + hp + "\nBank: " + bank + " Space dollars"
                + "\nWeapon: " + equippedWeapon + "\nArmor: " + equippedArmor
                + "\nDamage: " + dmg + "\nDefence: " + def
                + "\n=============================================================================";
    }

///////////////////////// INVENTORY /////////////////////////////////////////////
    /**
     * Adds the target object to the inventory array.
     *
     * @param item
     */
    public void addItemToInventory(Iitem item) {
        inventory.add(item);
    }

    /**
     * Prints out the inventory array.
     */
    public void showInventory() {
        System.out.println("\n------------INVENTORY------------");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print(inventory.get(i) + "\n");
        }
    }

    /**
     * When given objects name as a string, this method moves the targeted object from the room loot array to the players inventory array
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
     * Checks if the item exist in the Inventory Array, thereafter checks if the item is usable. If usable it runs the use() method in the item, then it removes item from the Inventory.
     *
     * @param item
     * @param player
     */
    public void useItem(String item, Player player) {
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
            }
        }

    }

    public void checkInventoryAndEquip(String item) {
        Boundry b = new Boundry();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(item)) {
                if (this.inventory.get(i).equipable() == true) {
                    this.inventory.get(i).equip(this);
                    
                    System.out.println(b.youEquipped() + this.inventory.get(i).getName() + "\n");
                    
                    this.inventory.remove(i);
                } else {
                    b.youCannotEquipItem();
                }
            } 
        }
    }

    public void checkEquippedItemAndUnequip(String item) {
        Boundry b = new Boundry();
        if (equippedWeapon != null && item.equalsIgnoreCase(equippedWeapon.getName())) {
            addItemToInventory(equippedWeapon);
            
            System.out.println(b.youUnequipped() + equippedWeapon.getName() + "\n");
            
            setEquippedWeapon(equippedWeapon = null);
            this.dmg = 1;
        } else if (equippedArmor != null && item.equalsIgnoreCase(equippedArmor.getName())) {
            addItemToInventory(equippedArmor);
            
            System.out.println(b.youUnequipped() + equippedArmor.getName() + "\n");
            
            setEquippedArmor(equippedArmor = null);
            this.def = 0;
            
        } else {
            b.nothingHappend();
        }
    }

    public Iitem checkInventoryForWinItem(String item) {
        Iitem returnItem = null;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(item)) {
                returnItem = inventory.get(i);
            }
        }
        return returnItem;
    }

}
