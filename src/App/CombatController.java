package App;

import App.Boundry;
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

    public int combat(Player player) {
        int combatOutcome;
        Boundry b = new Boundry();
        Random rnd = new Random();

        Monster monster = player.getCurrentRoom().getMonster();

//        boolean monsterTurn = true;
//        boolean playerTurn = true;
//        boolean whileFighting = true;
//        
        int damage = 0;

        if (monster.getMonsterHp() <= 0) {
            player.getCurrentRoom().setGold(monster.getMonsterGold());
            player.getCurrentRoom().setMonster(null);
            combatOutcome = 1;
        } else if (player.getHp() <= 0) {
            combatOutcome = 3;
        } else {
            int RollForMonsterAttack = rnd.nextInt(5);
            if (RollForMonsterAttack > 4) {
                damage = monster.monsterSpecialAttack(player);
                player.setHp(-damage);
                combatOutcome = 1;
            } else if (RollForMonsterAttack > 0 && RollForMonsterAttack <= 4) {
                damage = monster.monsterAttack(player);
                player.setHp(-damage);
                combatOutcome = 1;
            } else {
                System.out.println("Debug: The monster missed the attack");
                combatOutcome = 1;
            }
            b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());

        }

        return combatOutcome;

    }

}
