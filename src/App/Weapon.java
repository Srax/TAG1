package App;

/**
 *
 * @author Stanislav
 */
public class Weapon implements Iitem{
    String name, description;
    private int attackDMG;
    
    Weapon() {
       
    }    

    public Weapon(String name, String description, int attackDMG) {
        this.name = name;
        this.description = description;
        this.attackDMG = attackDMG;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public int getAttackDMG() {
        return attackDMG;
    }

    public void setAttackDMG(int attackDMG) {
        this.attackDMG = attackDMG;
    }

    @Override
    public String toString() {
        return "Weapon " + " name: " + name + " Attack Damage: "+attackDMG + " Description: "+getDescription();
    }

    @Override
    public String getDescription() {
        return description;
    }

}
