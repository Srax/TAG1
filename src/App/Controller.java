package App;

public class Controller {

    Boundry b = new Boundry();
    Player p = new Player();
    CreateRoom cr = new CreateRoom();
    Inventory inv = new Inventory();

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
//TEST        //  p.setName(b.createName());

        currentRoom = cr.startRoom;

        System.out.println(currentRoom.toString());
        Thread.sleep(500);
        while (checkVictory) {
            Thread.sleep(500);
            if (currentRoom.equals(cr.finish)) {
                System.out.println(cr.finish.getDescription());
                System.out.println(p.toString());
                //b.playSound(b.doorSound);
                b.youWon();
                checkVictory = false;
            } else if (currentRoom.equals(cr.spaceShip)) {
                System.out.println(cr.spaceShip());
                System.out.println(p.toString());
                //b.playSound(b.doorSound);
                checkVictory = false;
            } else {
                b.playSound(b.doorSound);
                currentRoom = playerAction(currentRoom);

            }
        }
    }

    /**
     * When the player choose to collect the money in the room, and modifies the
     * player gold entity
     */
    public void collectGold() {
        int gold = currentRoom.getGold();
        String pickup = "";

        if (gold > 0) {
            b.youFindGold(gold);
            pickup = b.takeGold();
            if (pickup.equalsIgnoreCase("yes")) {
                p.setBank(gold);
                b.playSound(b.coinSound);
                currentRoom.setGold(0);
            }

        } else {
            b.noGold();
        }
    }

    /**
     * Manages the players action input. The method is set up to print out all
     * the possible directions in the currentRoom. It then returns a new room to
     * place the player in.
     *
     * @param currentRoom
     * @return
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
                    collectGold();
                    break;

                case "north":
                    takingAction = north(action);
                    break;

                case "south":
                    takingAction = south(action);
                    break;

                case "east":
                    takingAction = east(action);
                    break;

                case "west":
                    takingAction = west(action);
                    break;
                case "help":
                    b.helpCommand();
                    break;
                case "pickup":
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
                default:
                    b.nothingHappend();
            }
        }
        return tempRoom;
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
            ////////////////////////////////////////////
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
                //////////////////////////////////////////////////
            }
        }
    }

    public void trap() {
        int trap = currentRoom.getTrap();
        if (trap > 0) {
            b.trapInteraction();
            p.setHp(-10);
            b.getHp(p);
            currentRoom.setTrap(0);
        }

    }

    public boolean north(String action) {
        boolean takingAction = true;

        if (action.equalsIgnoreCase("north") && currentRoom.getNorth() != null) {
            b.directionChoice(action);
            tempRoom = currentRoom.getNorth();
            return takingAction = false;

        } else {
            b.walkIntoWall();
            return takingAction = true;
        }
    }

    public boolean south(String action) {
        boolean takingAction = true;

        if (action.equalsIgnoreCase("south") && currentRoom.getSouth() != null) {
            b.directionChoice(action);
            tempRoom = currentRoom.getSouth();
            return takingAction = false;

        } else {
            b.walkIntoWall();
            return takingAction = true;
        }

    }

    public boolean east(String action) {
        boolean takingAction = true;

        if (action.equalsIgnoreCase("east") && currentRoom.getEast() != null) {
            b.directionChoice(action);
            tempRoom = currentRoom.getEast();
            return takingAction = false;

        } else {
            b.walkIntoWall();
            return takingAction = true;
        }

    }

    public boolean west(String action) {
        boolean takingAction = true;

        if (action.equalsIgnoreCase("west") && currentRoom.getWest() != null) {
            b.directionChoice(action);
            tempRoom = currentRoom.getWest();
            return takingAction = false;

        } else {
            b.walkIntoWall();
            return takingAction = true;
        }

    }

    private void potion() {
        if (currentRoom.getPotion() > 0) {

        }
    }

    private void pickUpItem() {

        b.chooseItemToPick();
        String choice = b.chooseAction();
        Iitem itemToMove = currentRoom.moveFromRoomToInventory(choice);

        if (itemToMove == null) {
            b.nothingHappend();

        } else {
            inv.add(itemToMove);
            
        }
    }

    private void dropItem() {
        inv.show();
        b.chooseItemToDrop();
        String choice = b.chooseAction();
        Iitem itemToMove = inv.MoveFromInventoryToRoom(choice);
            if(itemToMove == null){
            b.nothingHappend();
            }else{
                tempRoom.add(itemToMove);
                
            }
            
    
    }
}
