package MonsterTypes;

import Enteties.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DD
 */
public class PossessedChef extends Monster {

    public PossessedChef(String name, int hp, int dmg, int armor, int gold) {
        super(name, hp, dmg, armor, gold);
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

        System.out.println("The " + getMonsterName() + "swings his laser-Meatcleaver at you, and makes a deep cut");
        damage = this.getMonsterDmg() * 2 - p.getDef();

        return damage;
    }

}
