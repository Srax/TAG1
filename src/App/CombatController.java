package App;

import MonsterTypes.Monster;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DD
 */
public class CombatController {

    Boundry b = new Boundry();
    PlayerActionController playerActionCtrl = new PlayerActionController();
    Random rnd = new Random();

    public void combat(Player player) {
        int damage = 0;
        Monster monster = player.getCurrentRoom().getMonster();
        boolean combatStatus = true;

        while (combatStatus) {

            //     if (monster != null) {
            if (monster.getMonsterHp() <= 0) {
                player.getCurrentRoom().setGold(monster.getMonsterGold());
                b.monsterIsDead(monster.getMonsterName());
                monster.setMonsterHp(0);
                combatStatus = false;
                monster = null;
                player.getCurrentRoom().setMonster(null);
            } else {
                int rollForMonsterAttack = rnd.nextInt(5);
                if (rollForMonsterAttack > 4) {
                    damage = monster.monsterSpecialAttack(player);
                    player.setHp(-damage);
                    b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());

                    if (player.getHp() <= 0) {
                        player.setHp(0);
                        combatStatus = false;
                        monster = null;
                        player.getCurrentRoom().setMonster(null);
                    } else {
                        combatStatus = playerActionCtrl.combatAction(player);
                    }
                } else if (rollForMonsterAttack >= 1 && rollForMonsterAttack <= 4) {
                    damage = monster.monsterAttack(player);
                    player.setHp(-damage);
                    b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());
                    if (player.getHp() <= 0) {
                        player.setHp(0);
                        combatStatus = false;
                        monster = null;
                        player.getCurrentRoom().setMonster(null);
                    } else {
                        combatStatus = playerActionCtrl.combatAction(player);
                    }
                } else {
                    System.out.println("Debug: The monster missed the attack");
                }
            }

//            } else if (monster == null){
//                combatStatus = false;
        }
    }

}
//}
