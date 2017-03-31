package items;

/**
 *
 * @author Stanislav
 */
public class Weapon implements Iitem{
    String name, description;
    private int attackDMG;
    boolean usable=false;
    
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
        return "Weapon >" + "\""+name+"\"" + " DMG +"+attackDMG + " Description: \""+getDescription()+"\"";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean getUsable() {
        return this.usable;
    }

    @Override
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

}
