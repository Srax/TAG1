/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTypes;


/**
 *
 * @author DD
 */
public class CorruptedWiers extends Monster {

    public CorruptedWiers(String name, int hp, int dmg, int armor, int tier) {
        super(name, hp, dmg, armor, tier);
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
