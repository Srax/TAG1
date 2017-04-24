package items;

import Enteties.Player;

/**
 *
 * @author Stanislav
 */
public class Weapon implements Iitem{
    String name, description;
    private int attackDMG;
    private boolean usable=false, equipable = true;
    
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
        return "Weapon > " + "\""+name+"\"" + " DMG +"+attackDMG + " Description: \""+getDescription()+"\"";
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

    @Override
    public boolean equipable() {
        return equipable;
    }

    @Override
    public void use(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    /**
     * If the players equipped weapon is not null, add the weapon to inventory and equip it and set the players 'dmg' int to the value of the weapons.
     * 
     * @param player 
     */
    @Override
    public void equip(Player player){
    if(player.getEquippedWeapon()!= null){
            player.addItemToInventory(player.getEquippedWeapon());
            player.setEquippedWeapon(this);
        }else{
        player.setEquippedWeapon(this);
        }
        player.setDmg(this.attackDMG);
    }

}
