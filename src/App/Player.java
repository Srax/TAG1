
package App;


public class Player {
        
    private String name;
    private int dmg = 2,bank, def=0;
    private int hp = 100;
        
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
        if (this.hp>100){
            this.hp = 100;
        }
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
