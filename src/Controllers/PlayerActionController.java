/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Boundry.Boundry;
import Enteties.Player;
import Enteties.Room;
import MonsterTypes.Monster;

/**
 *
 * @author Stanislav
 */
public class PlayerActionController {

    ItemController iCtrl = new ItemController();
    Boundry b = new Boundry();

    /**
     * Manages the players action input. The method is set up to print out all
     * the possible directions in the currentRoom. It then returns a new room to
     * place the player in.
     *
     * @param player
     * @param cr
     */
    public void playerAction(Player player, CreateRoom cr) {
        
        String action = b.chooseAction();

        switch (action.toLowerCase()) {
            case "inspect":
                System.out.println(player.getCurrentRoom().toString());
                player.getCurrentRoom().availableDirections();
                break;
            case "search":
                player.getCurrentRoom().showLoot();
                checkGold(player);
                break;

            case "north":
                directionChoice(action, player);
                break;

            case "south":
                directionChoice(action, player);
                break;

            case "east":
                directionChoice(action, player);
                break;

            case "west":
                directionChoice(action, player);
                break;
            case "help":
                b.helpCommand();
                break;
            case "pickup":
            case "pick up":
                iCtrl.pickUpItem(player);
                break;
            case "drop":
                iCtrl.dropItem(player);
                break;
            case "bank":
                b.showBank(player);
                break;
            case "exit":
                player.setCurrentRoom(cr.spaceShip);
                break;
            case "inventory":
                player.showInventory();
                break;
            case "use":
                iCtrl.useItem(player);
                break;
            case "equip":
                iCtrl.equipItem(player);
                break;
            case "unequip":
            case "un equip":
                iCtrl.unEquipItem(player);
                break;
            case "stats":
                System.out.println(player.toString());
                break;
            //cheat to debug
            case "make it rain":
                player.setHp(+50);
                break;
            case "winnow":
                player.setCurrentRoom(cr.finish);
                break;
            default:
                b.nothingHappend();
                break;
        }

    }
    /**
 * Combat menu, used only when combatController is active.
 * @param player
 * @return 
 */
    public boolean combatAction(Player player) {
        boolean takingAction = true;
        boolean combatStatus = true;

        while (takingAction) {
            String action = b.chooseAction();
            switch (action.toLowerCase()) {
                case "run":
                    run(player);
                    combatStatus = false;
                    takingAction = false;
                    break;
                case "attack":
                    attack(player);
                    takingAction = false;
                    break;
                case "inventory":
                    player.showInventory();
                    break;
                case "use":
                    iCtrl.useItem(player);
                    break;
                case "help":
                    b.attackHelp();
                    break;
                //Cheats
                case "dance":
                    dance(player);
                    takingAction = false;
                    break;
                default:
                    b.nothingHappend();
                    break;
            }
        }
            return combatStatus;
        
    }

    /**
     * Takes an action, and checks if the direction is possible, in the current
     * room then sets the current Room to the room if available, else returns a
     * statement that the direction is not possible.
     *
     * @param action
     * @param player
     * @return takingAction
     */
    public boolean directionChoice(String action, Player player) {
        boolean takingAction = true;
        Room goToRoom = null;

        switch (action.toLowerCase()) {
            case "north":
                goToRoom = player.getCurrentRoom().getNorth();
                break;
            case "south":
                goToRoom = player.getCurrentRoom().getSouth();
                break;
            case "east":
                goToRoom = player.getCurrentRoom().getEast();
                break;
            case "west":
                goToRoom = player.getCurrentRoom().getWest();
                break;
        }

        if (goToRoom == null) {
            b.walkIntoWall(player);
            return takingAction = true;
        } else {
            player.setCurrentRoom(goToRoom);
            b.youWent(action);
            b.playSound(b.doorSound);
            return takingAction = false;

        }
    }

    /**
     * When the player choose to collect the money in the room, and modifies the
     * player gold entity
     * @param player
     */
    public void checkGold(Player player) {
        int gold = player.getCurrentRoom().getGold();
        if (gold > 0) {
            b.youFindGold(gold);

        }
    }
    /**
 * Calculates the attack damage, on monster.
 * @param player 
 */
    public void attack(Player player) {
        Monster monster = player.getCurrentRoom().getMonster();
        b.playSound(b.pewpewSound);
        monster.setMonsterHp(-player.getDmg());
        b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
    }
    /**
    * Sets the current Room to the last room, 
    * @param player 
    */
    public void run(Player player) {
            player.setCurrentRoom(player.getLastRoom());
    }
    /**
     * Debug (Cheat function) instantly kills monster.
     * @param player 
     */
    public void dance(Player player) {
        Monster monster = player.getCurrentRoom().getMonster();
        monster.setMonsterHp(-500000);
        b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
    }
}
