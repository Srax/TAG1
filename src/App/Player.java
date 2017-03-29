
package App;


public class Player {
        
    private String name;
    private int hp = 100,dmg = 10,bank, def=0;
        
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
