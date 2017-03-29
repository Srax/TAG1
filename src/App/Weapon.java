package App;

/**
 *
 * @author Stanislav
 */
public class Weapon implements Iitem{
    String name;
    private int attackDMG;
    
    Weapon() {
       
    }    
    
    @Override
    public void name(String name) {
        this.name = name;
    }


    public Weapon(int attackDMG, String name) {
        this.attackDMG = attackDMG;
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
        return "Weapon" + "name=" + name + "attackDMG="+attackDMG;
    }


    
    
}
