/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTypes;

import Enteties.Player;

/**
 *
 * @author Stanislav
 */
public class Plants extends Monster{
    
    public Plants(String name, int hp, int dmg, int armor,  int gold) {
        super(name, hp, dmg, armor, gold);
    }
            /**
     * Runs monster individual special attack, and returns int for CombatController with the DMG
     * @param p
     * @return 
     */
    @Override
    public int monsterSpecialAttack(Player p) {
        int damage = 0;

        System.out.println("The killer plant uses vinewhip, it was super effective.");
        damage = this.getMonsterDmg() * 2 - p.getDef();

        return damage;
    }
    
}
