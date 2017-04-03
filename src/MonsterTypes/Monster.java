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
    private int MonsterDefence;

    public Monster(String name, int hp, int dmg, int defence) {
        this.monsterName = name;
        this.monsterHp = hp;
        this.monsterDmg = dmg;
        this.MonsterDefence = defence;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String name) {
        this.monsterName = name;
    }

    public int getMonsterHp() {
        return monsterHp;
    }

    public void setMonsterHp(int hp) {
        this.monsterHp = hp;
    }

    public int getMonsterDmg() {
        return monsterDmg;
    }

    public void setMonsterDmg(int dmg) {
        this.monsterDmg = dmg;
    }

    public int getMonsterDefence() {
        return MonsterDefence;
    }

    public void setMonsterDefence(int MonsterDefence) {
        this.MonsterDefence = MonsterDefence;
    }

    public int monsterAttack(Player p) {
        int damage = 0;
        damage = getMonsterDmg() - p.getDef();
        return damage;
    }

}
