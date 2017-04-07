package App;

import MonsterTypes.Monster;
import highscore.HighscoreManager;
import items.Iitem;
import java.util.Random;

public class Controller {

    Random rnd = new Random();
    Boundry b = new Boundry();
    CreateRoom cr = new CreateRoom();
    Player player = new Player();
    HighscoreManager hm = new HighscoreManager();

//    Room currentRoom;
//    Room tempRoom = currentRoom;
    /**
     * Manages game, movement form room, to next room, checks for winning room,
     * collection of gold.
     *
     * @throws java.lang.InterruptedException
     */
    public void game() throws InterruptedException {

        boolean checkVictory = true;

        cr.roomFeatures();
        cr.addPlayerStartItems(player);
        b.welcomeToGame();
        int combatOutcome = 0;
        //b.createName(player);
        player.setCurrentRoom(cr.startRoom);
        System.out.println(player.getCurrentRoom().toString());
        Thread.sleep(500);

        while (checkVictory) {
            Thread.sleep(500);
            if (player.getCurrentRoom().equals(cr.finish)) {
                b.youWon(player.getCurrentRoom(), player);
                hm.addScore(player.getName(), player.getBank(), player.getHp());
                checkVictory = false;
            } else if (player.getCurrentRoom().equals(cr.spaceShip)) {
                b.youQuit(player.getCurrentRoom(), player);
                hm.addScore(player.getName(), player.getBank(), player.getHp());
                checkVictory = false;
            } else if ((player.getCurrentRoom().getMonster() != null)) {
                while (combatOutcome == 1) {
                    combatOutcome = combatController.combat(player);
                    if (combatOutcome == 2) {
                        player.setCurrentRoom(player.getLastRoom());
                    }else if(combatOutcome == 3){
                        item.useitems();
                    
                    } else if (combatOutcome == 4) {
                        b.youDied();
                        checkVictory = false;
                    }
                }
            }
        }
    }

    
        else {
                player.setLastRoom(player.getCurrentRoom());
    }

    b.playSound (b.doorSound);

}
}
//Prints highscore

System.out.print (hm.getHighscoreString());
    }

    /**
     * When the player choose to collect the money in the room, and modifies the
     * player gold entity
     */
    public void checkGold() {
        int gold = player.getCurrentRoom().getGold();
        if (gold > 0) {
            b.youFindGold(gold);

        }
    }

    /**
     * Manages the players action input. The method is set up to print out all
     * the possible directions in the currentRoom. It then returns a new room to
     * place the player in.
     *
     * @param currentRoom
     */
    /**
     * Interacts with the taxCollector. After a checking if there is a tax
     * collector in the room this method runs the possible outcomes of this
     * encounter based on player input.
     */
    public void taxRobot() {
        int taxRobot = player.getCurrentRoom().getTaxCollector();
        if (taxRobot > 0) {
            b.taxCollectorMeeting();
            boolean interaction = true;

            while (interaction) {
                String choice = b.chooseAction();
                if (player.getBank() > 20) {

                    if (choice.equalsIgnoreCase("pay")) {
                        player.setBank(-20);
                        b.taxCollectorPay(player);
                        player.getCurrentRoom().setTaxCollector(0);
                        interaction = false;
                    } else if (choice.equalsIgnoreCase("deny")) {
                        player.getCurrentRoom().setGold(player.getBank());
                        player.setBank(-player.getBank());
                        player.setHp(-20);
                        b.taxCollectorDeny(player);
                        player.getCurrentRoom().setTaxCollector(0);
                        interaction = false;
                    } else {
                        b.nothingHappend();
                    }

                } else if (choice.equalsIgnoreCase("help")) {
                    b.helpCommand();
                } else if (choice.equalsIgnoreCase("pay") || choice.equalsIgnoreCase("deny") && player.getBank() < 20) {
                    player.getCurrentRoom().setGold(player.getBank());

                    player.setHp(-20);
                    b.taxCollectorCantPay(player);
                    player.getCurrentRoom().setTaxCollector(0);
                    interaction = false;
                } else {
                    b.nothingHappend();
                }
            }
        }
    }

    /**
     * Runs the trap encounter.
     */
    public void trap() {
        int trap = player.getCurrentRoom().getTrap();
        if (trap > 0) {
            b.trapInteraction();
            player.setHp(-10);
            b.getHp(player);
            player.getCurrentRoom().setTrap(0);
        }

    }

    /**
     * This method allows the player to pick up an object from the rooms loot
     * array and moves it to the players inventory array
     */
    public void pickUpItem() {

        b.chooseItemToPick();
        String choice = b.chooseAction();

        if (choice.equalsIgnoreCase("space dollars") || choice.equalsIgnoreCase("money") && player.getCurrentRoom().getGold() > 0) {
            int gold = player.getCurrentRoom().getGold();

            player.setBank(gold);
            b.playSound(b.coinSound);
            player.getCurrentRoom().setGold(0);
            b.youPickedUp();
            System.out.println(gold + " Space Doallars\n");

        } else {

            Iitem itemToMove = player.getCurrentRoom().moveFromRoomToInventory(choice);

            if (itemToMove == null) {
                b.nothingHappend();

            } else {
                player.addItemToInventory(itemToMove);
                b.youPickedUp();
                System.out.println(itemToMove + "\n");

            }
        }
    }

    /**
     * This method allows the player to drop an object and and move it from the
     * players inventory array into the currentRooms loot array.
     */
    public void dropItem() {
        player.showInventory();
        b.chooseItemToDrop();
        String choice = b.chooseAction();
        Iitem itemToMove = player.MoveFromInventoryToRoom(choice);
        if (itemToMove == null) {
            b.nothingHappend();
        } else {
            player.getCurrentRoom().add(itemToMove);

        }

    }

    /**
     * Runs method for using items in the Inventory Class
     */
    public void useItem() {
        b.chooseItemToUse();
        String choice = b.chooseAction();
        player.useItem(choice, player);
    }

    public void equipItem() {
        b.witchItemToEquip();
        String choice = b.chooseAction();
        player.checkInventoryAndEquip(choice);
    }

    public void unEquipItem() {
        b.witchItemToUnequip();
        String choice = b.chooseAction();
        player.checkEquippedItemAndUnequip(choice);
    }

    public void combat(Room currentRoom, Player player) {
        Boundry b = new Boundry();
        Random rnd = new Random();

        boolean monsterTurn = true;
        boolean playerTurn = true;
        boolean whileFighting = true;
        int damage = 0;
        Monster monster = currentRoom.getMonster();

        if (monster == null) {
            whileFighting = false;
        } else {
            b.monsterEncounter(monster.getMonsterName());
            while (whileFighting == true) {

                if (monster.getMonsterHp() <= 0) {
                    System.out.println("Debug: The monster drops " + monster.getMonsterGold() + "$ into the room " + currentRoom.getGold());
                    currentRoom.setGold(monster.getMonsterGold());
                    b.monsterIsDead(monster.getMonsterName());
                    whileFighting = false;
                    currentRoom.setMonster(null);
                } else {
                    System.out.println("Debug: The room contains " + currentRoom.getGold());
                    while (monsterTurn == true) {
                        int RollForMonsterAttack = rnd.nextInt(5);

                        if (RollForMonsterAttack > 4) {
                            damage = monster.monsterSpecialAttack(player);
                            player.setHp(-damage);

                        } else if (RollForMonsterAttack > 0 && RollForMonsterAttack <= 4) {
                            damage = monster.monsterAttack(player);
                            player.setHp(-damage);

                        } else {
                            System.out.println("Debug: The monster miss the attack");
                        }
                        b.monsterAttacksYou(monster.getMonsterName(), damage, player.getHp());
                        monsterTurn = false;
                        playerTurn = true;

                    }
                    while (playerTurn == true) {
                        playerAction(currentRoom);
                        monsterTurn = true;
                        playerTurn = false;
                    }

                }

            }
        }

    }

    /**
     * Takes a action, and checks if the direction is possible, in the current
     * room then sets the current Room to the room if available, else returns a
     * statement that the direction is not possible.
     *
     * @param action
     * @return takingAction
     */
    public boolean directionChoice(String action) {
        boolean takingAction = true;
        Room goToRoom = null;

        switch (action) {
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

    public void playerAction(Room currentRoom) {
        boolean takingAction = true;

        while (takingAction) {
            String action = b.chooseAction();

            switch (action.toLowerCase()) {
//                case "dance":
//                    combatController.dance(currentRoom.getMonster());
//                    break;
//                
//                case "run":
//                    combatController.run(currentRoom.getMonster());
//                    break;
                case "attack":
                    attack(player);
                    break;
                case "inspect":
                    System.out.println(currentRoom.toString());
                    currentRoom.availableDirections();
                    break;
                case "search":
                    trap();
                    currentRoom.showLoot();
                    checkGold();
                    break;

                case "north":
                    takingAction = directionChoice(action);
                    break;

                case "south":
                    takingAction = directionChoice(action);
                    break;

                case "east":
                    takingAction = directionChoice(action);
                    break;

                case "west":
                    takingAction = directionChoice(action);
                    break;
                case "help":
                    b.helpCommand();
                    break;
                case "pickup":
                case "pick up":
                    pickUpItem();
                    break;
                case "drop":
                    dropItem();
                    break;
                case "bank":

                    b.showBank(player);
                    break;
                case "exit":
                    player.setCurrentRoom(cr.spaceShip);
                    takingAction = false;
                    break;
                case "inventory":
                    player.showInventory();
                    break;
                case "use":
                    useItem();
                    break;
                case "equip":
                    equipItem();
                    break;
                case "unequip":
                case "un equip":

                    unEquipItem();
                    break;
                case "stats":
                    System.out.println(player.toString());
                    break;
                //cheat to debug
                case "make it rain":
                    player.setHp(+50);
                    break;
                default:
                    b.nothingHappend();
                    break;
            }
        takingAction = false;}

    }

    public void attack(Player p) {
        System.out.println("debug 1");
        System.out.println("debug 2");

        Monster monster = p.getCurrentRoom().getMonster();
        if (monster != null) {
            System.out.println("debug 3");
            monster.setMonsterHp(-p.getDmg());
            b.playerAttackMonster(monster.getMonsterName(), p.getDmg(), monster.getMonsterHp());

        } else {
            System.out.println("debug 4");
            b.nothingHappend();
        }

    }

}
