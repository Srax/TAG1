/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTypes;

import App.Player;

/**
 *
 * @author DD
 */
public class CorruptesWiers extends Monster {

    private int tier; 
            
    public CorruptesWiers(String name, int hp, int dmg, int defence ) {
        super(name, hp, dmg, defence);
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Name: " + getMonsterName()
                + "\n"
                + "HP: " + getMonsterHp()
                +"\n"
                + "Damage: " + getMonsterDmg()
                +"\n"
                + "Armor: " + getMonsterArmor();
    }

    
    
}
