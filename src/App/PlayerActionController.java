/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import MonsterTypes.Monster;

/**
 *
 * @author Stanislav
 */
public class PlayerActionController {

    Boundry b = new Boundry();
    ItemController iCtrl = new ItemController();
    CreateRoom cr = new CreateRoom();

    /**
     * Manages the players action input. The method is set up to print out all
     * the possible directions in the currentRoom. It then returns a new room to
     * place the player in.
     *
     * @param player
     */
    public void playerAction(Player player) {

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
            case "win":
                player.setCurrentRoom(cr.finish);
                break;
            default:
                b.nothingHappend();
                break;
        }

    }

    public boolean combatAction(Player player) {
        boolean takingAction = true;
        boolean combatStatus = true;

        while (takingAction) {
            String action = b.chooseAction();
            switch (action.toLowerCase()) {
                case "dance":
                    dance(player);
                    takingAction = false;
                    break;
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
                default:
                    b.nothingHappend();
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
            return takingAction = false;

        }
    }

    /**
     * When the player choose to collect the money in the room, and modifies the
     * player gold entity
     */
    public void checkGold(Player player) {
        int gold = player.getCurrentRoom().getGold();
        if (gold > 0) {
            b.youFindGold(gold);

        }
    }

    public void attack(Player player) {
        Monster monster = player.getCurrentRoom().getMonster();

        if (monster != null) {

            monster.setMonsterHp(-player.getDmg());
            b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());

        } else {
            b.nothingHappend();
        }

    }

    public void run(Player player) {
        Monster monster = player.getCurrentRoom().getMonster();
        if (monster != null) {
            player.setCurrentRoom(player.getLastRoom());
        } else {

            b.nothingHappend();
        }
    }

    public void dance(Player player) {
        Monster monster = player.getCurrentRoom().getMonster();
        if (monster != null) {
            monster.setMonsterHp(-500000);
            b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());

        } else {
            b.nothingHappend();
        }

    }
}
