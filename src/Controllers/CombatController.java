package Controllers;

import Boundry.Boundry;
import Enteties.Player;
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
/**
 * Creates a combat loop, and continues until player or monster is dead.
 * @param player
 * @throws InterruptedException 
 */
    public void combat(Player player) throws InterruptedException {
        int damage = 0;
        Monster monster = player.getCurrentRoom().getMonster();
        boolean combatStatus = true;
        
        b.monsterEncounter(monster.getMonsterName());
        while (combatStatus) {

            //Checks if monster HP is under 0, if true, it runs methods to drop items and gold, 
            //and sets the monster to null for the rest of the game, and breaks the loop.
            if (monster.getMonsterHp() <= 0) {
                monster.moveMonsterItemToRoom(player);
                player.getCurrentRoom().setMonsterGold(monster.getMonsterGold());
                b.monsterIsDead(monster.getMonsterName());
                monster.setMonsterHp(0);
                combatStatus = false;
                monster = null;
                player.getCurrentRoom().setMonster(null);
            } else {
            
            //Creates a random number, wich outcome decides what the monster will do
                int rollForMonsterAttack = rnd.nextInt(6);
                
            //If the number is 4 (20% chance) for Critical hit (double DMG) 
                if (rollForMonsterAttack > 4) {
                    damage = monster.monsterSpecialAttack(player);
                    player.setHp(-damage);
                    b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());
                    Thread.sleep(1000);
                    b.playSound(b.smashSound);
                    // Checks player HP
                    if (player.getHp() <= 0) {
                        player.setHp(0);
                        combatStatus = false;
                        monster = null;
                        player.getCurrentRoom().setMonster(null);
                    } else {
                        combatStatus = playerActionCtrl.combatAction(player);
                    }
                    
            //If the number is between 1-4 (60% chance) it is a regular attack
                } else if (rollForMonsterAttack >= 1 && rollForMonsterAttack <= 4) {
                    damage = monster.monsterAttack(player);
                    player.setHp(-damage);
                    b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());
                    Thread.sleep(1000);
                    b.playSound(b.smashSound);
                    if (player.getHp() <= 0) {
                        player.setHp(0);
                        combatStatus = false;
                        monster = null;
                        player.getCurrentRoom().setMonster(null);
                    } else {
                        combatStatus = playerActionCtrl.combatAction(player);
                        }
                } else {
                    
            //If the number is below 1 (20% chance) the monster will miss.
                    b.monsterMissed();
                    combatStatus = playerActionCtrl.combatAction(player);
                    b.playSound(b.pewpewSound);
                }
            }


        }
    }
    
}

