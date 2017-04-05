/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTypes;

/**
 *
 * @author thoma
 */
public class Styhr extends Monster {
    
    public Styhr(String name, int hp, int dmg, int armor, int tier, int gold) {
        super(name, hp, dmg, armor, tier, gold);
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
