
package App;

import java.util.ArrayList;

public class Player {
        
    private String name;
    private int hp = 100;
    private int bank;
    private int dmg = 10;
    ArrayList inventory = new ArrayList<>();

    public void getInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i)+" ,");
            
        }

       
    }

    public void setInventory() {
        inventory.add(p);
        this.inventory = inventory;
    }
   

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Player: " + name + "\nHP: " + hp + "\nBank: " + bank + " Space dollars";
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
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        if(bank < 0)
        {
            System.out.println("");
        }
        this.bank += bank;
    } 
}
