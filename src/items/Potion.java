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
 * This is a 'potion'. Potions are used to regain HP.
 */
public class Potion implements Iitem{
    
    String name, description;
    private int hpRestore;
    private boolean usable = true, equipable = false;

    
    //Construct potion using name, description and type.
    public Potion(String name, String description, int type) {
        this.name = name;
        this.description = description;
               
        //Depending on the potion type, it will heal 10, 20 or 30.
        switch(type){
            case 1: this.hpRestore = 10;
                    break;
            case 2: this.hpRestore = 20;
                    break;
            case 3: this.hpRestore = 30;
                    break;
             }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "Stimpack > " +"\""+name+"\"" + " Restores "+hpRestore+"HP " + "Description: \""+getDescription()+"\"";
    }

    public int getHpRestore() {
        return hpRestore;
    }

    public void setHpRestore(int hpRestore) {
        this.hpRestore = hpRestore;
    }

    @Override
    public boolean getUsable() {
        return this.usable;
    }

    @Override
    public void setUsable(boolean usable) {
        this.usable = usable;
    }
    
    /**
     * If the player use the potion, the potions hpRestore value will be added to the players hp.
     * @param player 
     */
    @Override
    public void use(Player player){
        player.setHp(hpRestore);
        
    }

    @Override
    public boolean equipable() {
        return equipable;
    }

    @Override
    public void equip(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
