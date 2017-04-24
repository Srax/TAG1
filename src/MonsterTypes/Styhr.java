/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTypes;

import Enteties.Player;

/**
 *
 * @author thoma
 */
public class Styhr extends Monster {

    public Styhr(String name, int hp, int dmg, int armor, int gold) {
        super(name, hp, dmg, armor, gold);
    }

    @Override
    public String toString() {
        return "Name: " + getMonsterName()
                + "\n"
                + "HP: " + getMonsterHp()
                + "\n"
                + "Damage: " + getMonsterDmg()
                + "\n"
                + "Armor: " + getMonsterArmor();
    }

    /**
     * Runs monster individual special attack, and returns int for
     * CombatController with the DMG
     *
     * @param p
     * @return
     */
    @Override
    public int monsterSpecialAttack(Player p) {
        int damage = 0;

        System.out.println("The Wier hisses at you and  release a powerfull electricfield"
                + "it hits you for a great amount of damage");
        damage = this.getMonsterDmg() * 2 - p.getDef();

        return damage;
    }
}
