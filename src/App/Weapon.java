package App;

/**
 *
 * @author Stanislav
 */
public class Weapon implements Iitem{
    String name, descrition;
    private int attackDMG, amountOf;
    
    Weapon() {
       
    }    

    public Weapon(String name, String descrition, int attackDMG, int amountOf) {
        this.name = name;
        this.descrition = descrition;
        this.attackDMG = attackDMG;
        this.amountOf = amountOf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public int getAmountOf() {
        return amountOf;
    }

    public void setAmountOf(int amountOf) {
        this.amountOf = amountOf;
    }
    @Override
    public void description(String desc) {
    }

    @Override
    public void amountOf(int amount) {
    }    
  

    public int getAttackDMG() {
        return attackDMG;
    }

    public void setAttackDMG(int attackDMG) {
        this.attackDMG = attackDMG;
    }

    @Override
    public String toString() {
        return "Weapon " + "name= " + name + "attackDMG= "+attackDMG+"Quantity= "+amountOf;
    }

}
