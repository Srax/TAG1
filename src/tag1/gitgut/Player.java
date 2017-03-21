
package tag1.gitgut;

public class Player {
        
    private String name;
    private int hp;
    private int bank;

    public Player() {
    }

    
    public Player(String name) {
        this.name = name;
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
        this.hp = hp;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank += bank;
    } 
}
