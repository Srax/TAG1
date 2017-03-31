package App;

import highscore.HighscoreManager;
import items.Iitem;

public class Controller {

    Boundry b = new Boundry();
    Player p = new Player();
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
        b.createName(p);
        currentRoom = cr.startRoom;

        System.out.println(currentRoom.toString());
        Thread.sleep(500);
        while (checkVictory) {
            Thread.sleep(500);
            if (currentRoom.equals(cr.finish)) {
                b.youWon(currentRoom, p);
                hm.addScore(p.getName(), p.getBank(), p.getHp());
                checkVictory = false;
            } else if (currentRoom.equals(cr.spaceShip)) {
                b.youQuit(currentRoom, p);
                hm.addScore(p.getName(), p.getBank(), p.getHp());
                checkVictory = false;
            } else {
                b.playSound(b.doorSound);
                currentRoom = playerAction(currentRoom);
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
                    b.showBank(p);
                    break;
                case "exit":
                    tempRoom = cr.spaceShip;
                    takingAction = false;
                    break;
                case "inventory":
                    inv.show();
                    break;
                case "yes": System.out.println("");
                    break;
                default:
                    b.nothingHappend();
                    break;
            }
        }
        return tempRoom;
    }

    /**
 * Takes a action, and checks if the direction is possible, in the current room
 * then sets the current Room to the room if available, else returns a statement
 * that the direction is not possible.
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
                if (p.getBank() > 20) {

                    if (choice.equalsIgnoreCase("pay")) {
                        p.setBank(-20);
                        b.taxCollectorPay(p);
                        currentRoom.setTaxCollector(0);
                        interaction = false;
                    } else if (choice.equalsIgnoreCase("deny")) {
                        currentRoom.setGold(p.getBank());
                        p.setBank(-p.getBank());
                        p.setHp(-20);
                        b.taxCollectorDeny(p);
                        currentRoom.setTaxCollector(0);
                        interaction = false;
                    } else {
                        b.nothingHappend();
                    }

                } else if (choice.equalsIgnoreCase("help")) {
                    b.helpCommand();
                } else if (choice.equalsIgnoreCase("pay") || choice.equalsIgnoreCase("deny") && p.getBank() < 20) {
                    currentRoom.setGold(p.getBank());

                    p.setHp(-20);
                    b.taxCollectorCantPay(p);
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
            p.setHp(-10);
            b.getHp(p);
            currentRoom.setTrap(0);
        }

    }

    /**
     * This method allows the player to pick up an object from the rooms loot 
     * array and moves it to the players inventory array
     */
    private void pickUpItem() {

        b.chooseItemToPick();
        String choice = b.chooseAction();

        if (choice.equalsIgnoreCase("money") && currentRoom.getGold()>0) {
            int gold = currentRoom.getGold();

            p.setBank(gold);
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
    private void dropItem() {
        inv.show();
        b.chooseItemToDrop();
        String choice = b.chooseAction();
        Iitem itemToMove = inv.MoveFromInventoryToRoom(choice);
        if (itemToMove == null) {
            b.nothingHappend();
        } else {
            tempRoom.add(itemToMove);

        }

    }
}
