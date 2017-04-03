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
public abstract class Monster {

    private String monsterName;
    private int monsterHp;
    private int monsterDmg;
    private int MonsterArmor;

    public Monster(String name, int hp, int dmg, int armor) {
        this.monsterName = name;
        this.monsterHp = hp;
        this.monsterDmg = dmg;
        this.MonsterArmor = armor;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterHp() {
        return monsterHp;
    }

    public void setMonsterHp(int monsterHp) {
        this.monsterHp = monsterHp;
    }

    public int getMonsterDmg() {
        return monsterDmg;
    }

    public void setMonsterDmg(int monsterDmg) {
        this.monsterDmg = monsterDmg;
    }

    public int getMonsterArmor() {
        return MonsterArmor;
    }

    public void setMonsterArmor(int MonsterArmor) {
        this.MonsterArmor = MonsterArmor;
    }
    
    
    
    public int monsterAttack(Player p) {
        int damage = 0;
        
        damage = this.monsterDmg - p.getDef();
        
        return damage;
    }
}
