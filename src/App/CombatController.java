/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import MonsterTypes.Monster;
import java.util.Random;

/**
 *
 * @author DD
 */
public class CombatController {

    Boundry b = new Boundry();
    
//    public void combat(Room currentRoom, Player player) {
//        Boundry b = new Boundry();
//        Random rnd = new Random();
//        Controller c = new Controller();
//
//        boolean monsterTurn = true;
//        boolean playerTurn = true;
//        boolean whileFighting = true;
//        int damage = 0;
//        Monster monster = currentRoom.getMonster();
//
//        String choice = "";
//
//        if (monster == null) {
//            whileFighting = false;
//        } else {
//            b.monsterEncounter(monster.getMonsterName());
//            while (whileFighting == true) {
//
//                if (monster.getMonsterHp() <= 0) {
//                    System.out.println("Debug: The monster drops " + monster.getMonsterGold() + "$ into the room " + currentRoom.getGold());
//                    currentRoom.setGold(monster.getMonsterGold());
//                    b.monsterIsDead(monster.getMonsterName());
//                    whileFighting = false;
//                    currentRoom.setMonster(null);
//                } else {
//                    System.out.println("Debug: The room contains " + currentRoom.getGold());
//                    while (monsterTurn == true) {
//                        int RollForMonsterAttack = rnd.nextInt(5);
//
//                        if (RollForMonsterAttack > 4) {
//                            damage = monster.monsterSpecialAttack(player);
//                            player.setHp(-damage);
//
//                        } else if (RollForMonsterAttack > 0 && RollForMonsterAttack <= 4) {
//                            damage = monster.monsterAttack(player);
//                            player.setHp(-damage);
//
//                        } else {
//                            System.out.println("Debug: The monster miss the attack");
//                        }
//                        b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());
//                        monsterTurn = false;
//                        playerTurn = true;
//
//                    }
//                    while (playerTurn == true) {
//                        c.playerAction(currentRoom);
//                        monsterTurn = true;
//                        playerTurn = false;
//                    }
//
//                }
//
//            }
//        }
//
//    }
//
//    public void attack(Room currentRoom) {
//        System.out.println("debug 1");
//        System.out.println("debug 2");
//        
//        if (monster != null) {
//            System.out.println("debug 3");
//            monster.setMonsterHp(-player.getDmg());
//            b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
//
//        } else {
//            System.out.println("debug 4");
//            b.nothingHappend();
//        }
//
//    }
//
//    public void run(Room currentRoom) {
//        Monster monster = player.getCurrentRoom().getMonster();
//        if (monster != null) {
//            player.setCurrentRoom(player.getLastRoom());
//        } else {
//
//            b.nothingHappend();
//        }
//    }
//
//    public void dance(Room currentRoom) {
//        Monster monster = player.getCurrentRoom().getMonster();
//        if (monster != null) {
//            monster.setMonsterHp(-500000);
//            b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
//
//        } else {
//            b.nothingHappend();
//        }
//
//    }

}
