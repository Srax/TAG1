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

    public CorruptesWiers(String name, int hp, int dmg, int armor, int tier) {
        super(name, hp, dmg, armor, tier);
    }
    
    @Override
    public String toString() {
        return "Tier: " + getMonsterTier()
                + "\n"
                + "Name: " + getMonsterName()
                + "\n"
                + "HP: " + getMonsterHp()
                +"\n"
                + "Damage: " + getMonsterDmg()
                +"\n"
                + "Armor: " + getMonsterArmor();
    }

  

    

    
    
}
