package App;

import MonsterTypes.CorruptedWiers;
import MonsterTypes.Monster;
import highscore.HighscoreManager;
import items.Iitem;
import java.util.Random;

public class Controller {
    Random rnd = new Random();
    Monster mon;
    Boundry b = new Boundry();
    Player player = new Player();
    CreateRoom cr = new CreateRoom();
    Inventory inv = new Inventory();
    HighscoreManager hm = new HighscoreManager();

    Room currentRoom;
    Room tempRoom = currentRoom;

    /**
     * Manages game, movement form room, to next room, checks for winning room,
     * collection of gold.
     *
     * @throws java.lang.InterruptedException
     */
    public void game() throws InterruptedException {

        boolean checkVictory = true;

        cr.roomFeatures();
        b.welcomeToGame();
        b.createName(player);
        currentRoom = cr.startRoom;

        System.out.println(currentRoom.toString());
        Thread.sleep(500);

        while (checkVictory) {
            Thread.sleep(500);
            if (currentRoom.equals(cr.finish)) {
                b.youWon(currentRoom, player);
                hm.addScore(player.getName(), player.getBank(), player.getHp());
                checkVictory = false;
            } else if (currentRoom.equals(cr.spaceShip)) {
                b.youQuit(currentRoom, player);
                hm.addScore(player.getName(), player.getBank(), player.getHp());
                checkVictory = false;
            } else {
                b.playSound(b.doorSound);
                player.setLastRoom(currentRoom);
                currentRoom = playerAction(currentRoom);
                currentRoom.setMonster(combat(currentRoom.getMonster(), player));
                
            }
        }
        //Prints highscore
        System.out.print(hm.getHighscoreString());
    }

    /**
     * When the player choose to collect the money in the room, and modifies the
     * player gold entity
     */
    public void checkGold() {
        int gold = currentRoom.getGold();
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
     * @return tempRoom
     */
    public Room playerAction(Room currentRoom) {
        boolean takingAction = true;

        while (takingAction) {
            String action = b.chooseAction();

            switch (action) {

                case "inspect":
                    System.out.println(currentRoom.toString());
                    taxRobot();
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
                    tempRoom = cr.spaceShip;
                    takingAction = false;
                    break;
                case "inventory":
                    inv.show();
                    break;
                case "use":
                    useItem();
                    break;
                default:
                    b.nothingHappend();
                    break;
            }
        }
        return tempRoom;
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
                goToRoom = currentRoom.getNorth();
                break;
            case "south":
                goToRoom = currentRoom.getSouth();
                break;
            case "east":
                goToRoom = currentRoom.getEast();
                break;
            case "west":
                goToRoom = currentRoom.getWest();
                break;
        }
        if (goToRoom == null) {
            b.walkIntoWall();
            return takingAction = true;
        } else {
            tempRoom = goToRoom;
            return takingAction = false;

        }
    }

    /**
     * Interacts with the taxCollector. After a checking if there is a tax
     * collector in the room this method runs the possible outcomes of this
     * encounter based on player input.
     */
    public void taxRobot() {
        int taxRobot = currentRoom.getTaxCollector();
        if (taxRobot > 0) {
            b.taxCollectorMeeting();
            boolean interaction = true;

            while (interaction) {
                String choice = b.chooseAction();
                if (player.getBank() > 20) {

                    if (choice.equalsIgnoreCase("pay")) {
                        player.setBank(-20);
                        b.taxCollectorPay(player);
                        currentRoom.setTaxCollector(0);
                        interaction = false;
                    } else if (choice.equalsIgnoreCase("deny")) {
                        currentRoom.setGold(player.getBank());
                        player.setBank(-player.getBank());
                        player.setHp(-20);
                        b.taxCollectorDeny(player);
                        currentRoom.setTaxCollector(0);
                        interaction = false;
                    } else {
                        b.nothingHappend();
                    }

                } else if (choice.equalsIgnoreCase("help")) {
                    b.helpCommand();
                } else if (choice.equalsIgnoreCase("pay") || choice.equalsIgnoreCase("deny") && player.getBank() < 20) {
                    currentRoom.setGold(player.getBank());

                    player.setHp(-20);
                    b.taxCollectorCantPay(player);
                    currentRoom.setTaxCollector(0);
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
        int trap = currentRoom.getTrap();
        if (trap > 0) {
            b.trapInteraction();
            player.setHp(-10);
            b.getHp(player);
            currentRoom.setTrap(0);
        }

    }

    /**
     * This method allows the player to pick up an object from the rooms loot
     * array and moves it to the players inventory array
     */
    public void pickUpItem() {

        b.chooseItemToPick();
        String choice = b.chooseAction();

        if (choice.equalsIgnoreCase("space dollars") && currentRoom.getGold() > 0) {
            int gold = currentRoom.getGold();

            player.setBank(gold);
            b.playSound(b.coinSound);
            currentRoom.setGold(0);

        } else {

            Iitem itemToMove = currentRoom.moveFromRoomToInventory(choice);

            if (itemToMove == null) {
                b.nothingHappend();

            } else {
                inv.add(itemToMove);

            }
        }
    }

    /**
     * This method allows the player to drop an object and and move it from the
     * players inventory array into the currentRooms loot array.
     */
    public void dropItem() {
        inv.show();
        b.chooseItemToDrop();
        String choice = b.chooseAction();
        Iitem itemToMove = inv.MoveFromInventoryToRoom(choice);
        if (itemToMove == null) {
            b.nothingHappend();
        } else {
            currentRoom.add(itemToMove);

        }

    }

    /**
     * Runs method for using items in the Inventory Class
     */
    public void useItem() {
        b.chooseItemToUse();
        String choice = b.chooseAction();
        inv.use(choice, player);
    }

    
    
    
    
    
    
    
    public Monster combat(Monster monster, Player player) {
        boolean monsterTurn = true;
        boolean playerTurn = true;
        boolean whileFighting = true;
        int damage = 0;
        Monster returnMonster = monster;
        
        String choice = "";
        
        
        if (monster == null) {
            whileFighting = false;
        } else {
            b.monsterEncounter(monster.getMonsterName());
            while (whileFighting == true) {
                
                if (monster.getMonsterHp() <= 0) {
                    System.out.println("The monster drops " + monster.getMonsterGold()+"$ into the room " + currentRoom.getGold());
                    currentRoom.setGold(monster.getMonsterGold());
                    b.monsterIsDead(monster.getMonsterName());
                    whileFighting = false;
                    returnMonster = null;
                    
                } else {
                    System.out.println("Debug: The room contains " + currentRoom.getGold());
                    while (monsterTurn == true) {
                        int whatMonsterAttack = rnd.nextInt(5);
                        
                        if(whatMonsterAttack > 4){
                            damage = monster.monsterSpecialAttack(player);
                            player.setHp(-damage);
                        
                        }else if(whatMonsterAttack > 0 && whatMonsterAttack <= 4){
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
                                inv.show();
                                break;
                            case "use":
                                useItem();
                                playerTurn = false;
                                monsterTurn = true;
                                break;
                            case "attack":
                                monster.setMonsterHp(-player.getDmg());
                                b.playerAttackMonster(monster.getMonsterName(), player.getDmg(), monster.getMonsterHp());
                                playerTurn = false;
                                monsterTurn = true;
                                break;
                            case "exit":
                                currentRoom = cr.spaceShip;
                                whileFighting = false;
                                playerTurn = false;
                                break;
                            case "run":
                                currentRoom = player.getLastRoom();
                                whileFighting = false;
                                playerTurn = false;
                                break;
                                 default:
                                b.nothingHappend();
                        }

                    }

                }

            }

        }
        return returnMonster;
    }

}
