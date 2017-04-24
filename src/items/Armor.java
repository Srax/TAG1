/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import Enteties.Player;

/**
 *
 * @author jonas
 */
public class Armor implements Iitem{
    String name, description;
    private int defense;
    boolean usable = false, equipable = true;
    
    Armor() {
       
    }    

    
    public Armor(String name, String description, int defense) {
        this.name = name;
        this.description = description;
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Armor > " + "\""+name+"\"" + " Defense +"+defense + " Description: \""+getDescription()+"\"";
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
    public void use(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equipable() {
        return this.equipable;
    }
    
    /**
     * If the players equipped armor is not null, add armor to inventory and equip it and set the players 'defense' int to the value of the armors.
     * 
     * @param player 
     */
    @Override
    public void equip(Player player){
        if(player.getEquippedArmor()!= null){
            player.addItemToInventory(player.getEquippedArmor());
            player.setEquippedArmor(this);
        }else{
        player.setEquippedArmor(this);
        }
        player.setDef(this.defense);
    }

}

