package App;

import MonsterTypes.Monster;
import items.Armor;
import items.Iitem;
import items.Weapon;
import java.util.ArrayList;

public class Player {

    //Players position, and last position
    private Room currentRoom = null;
    private Room lastRoom = null;

    //Player Stats
    private String name = "Random Guy";
    private int dmg = 1, bank, def = 0;
    private int hp = 14;

    //Plyer inventory and management
    private ArrayList<Iitem> inventory = new ArrayList<>();
    private Weapon equippedWeapon = null;
    private Armor equippedArmor = null;

    //Getters
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public int getDmg() {
        return dmg;
    }

    //Setters
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;

    }

    public Room getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "=============================================================================="
                + "\nPlayer: " + name + "\nHP: " + hp + "\nBank: " + bank + " Space dollars"
                + "\nWeapon: " + equippedWeapon + "\nArmor: " + equippedArmor
                + "\nDamage: " + dmg + "\nDefence: " + def
                + "\n=============================================================================";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
        if (this.hp > 100) {
            this.hp = 100;
        }else if (this.hp <0){
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

    public int playerAttack(Monster m) {
        int damage = 0;
        damage = this.dmg - m.getMonsterArmor();
        return damage;

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
     * Checks if the item exist in the Inventory Array, thereafter checks if the
     * item is usable. If usable it runs the use() method in the item, then it
     * removes item from the Inventory.
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
                    this.inventory.remove(i);
                } else {
                    b.youCannotEquipItem();
                }
            }
        }
    }

    public void checkEquippedItemAndUnequip(String item) {
        if (item.equals("weapon")) {
            addItemToInventory(equippedWeapon);
            setEquippedWeapon(equippedWeapon = null);
        } else if (item.equals("armor")) {
            addItemToInventory(equippedArmor);
            setEquippedArmor(equippedArmor = null);
        }
    }

}
