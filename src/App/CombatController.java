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
    
    
        public boolean combat(Room currentRoom, Player player) {
        Boundry b = new Boundry();
        Random rnd = new Random();
        Controller c = new Controller();
        CreateRoom cr = new CreateRoom();
        
        
        boolean monsterTurn = true;
        boolean playerTurn = true;
        boolean whileFighting = true;
        int damage = 0;
        boolean takingaction = true;
        Monster monster = currentRoom.getMonster();
        Room returnRoom = currentRoom;
        String choice = "";
        
        
        if (monster == null) {
            whileFighting = false;
        } else {
            b.monsterEncounter(monster.getMonsterName());
            while (whileFighting == true) {
                
                if (monster.getMonsterHp() <= 0) {
                    System.out.println("Debug: The monster drops " + monster.getMonsterGold()+"$ into the room " + currentRoom.getGold());
                    currentRoom.setGold(monster.getMonsterGold());
                    b.monsterIsDead(monster.getMonsterName());
                    whileFighting = false;
                    currentRoom.setMonster(null);
                } else {
                    System.out.println("Debug: The room contains " + currentRoom.getGold());
                    while (monsterTurn == true) {
                        int RollForMonsterAttack = rnd.nextInt(5);
                        
                        if(RollForMonsterAttack > 4){
                            damage = monster.monsterSpecialAttack(player);
                            player.setHp(-damage);
                        
                        }else if(RollForMonsterAttack > 0 && RollForMonsterAttack <= 4){
                            damage = monster.monsterAttack(player);
                            player.setHp(-damage);
                        
                        }else{
                            System.out.println("Debug: The monster miss the attack");
                        }
                        b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());
                        monsterTurn = false;
                        playerTurn = true;

                    }
                    while (playerTurn == true) {

                        choice = b.chooseAction();
                        switch (choice) {
                            case "help":
                                b.helpCommand();
                                break;
                            case "inventory":
                                player.showInventory();
                                break;
                            case "use":
                                c.useItem();
                                playerTurn = false;
                                monsterTurn = true;
                                break;
                            case "attack":
                                monster.setMonsterHp(-player.getDmg());
                                b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
                                playerTurn = false;
                                monsterTurn = true;
                                break;
                            case "dance":
                                monster.setMonsterHp(-5000);
                                b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
                                playerTurn = false;
                                monsterTurn = true;
                                break;
                            case "exit":
                                player.setCurrentRoom(cr.spaceShip);
                                whileFighting = false;
                                playerTurn = false;
                                takingaction = false;
                                break;
                            case "run":
                                player.setCurrentRoom(player.getLastRoom());whileFighting = false;
                                playerTurn = false;
                                break;
                                 default:
                                b.nothingHappend();
                        }

                    }

                }

            }

        }
    return takingaction;}
    
}
