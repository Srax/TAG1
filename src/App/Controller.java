package App;

import java.util.Random;

public class Controller {

    Boundry b = new Boundry();
    Random r = new Random();
    Player p = new Player();
    Description desc = new Description();

    Room currentRoom;

    //Creates the Rooms as individual objects
    Room spaceShip = new Room(0, desc.spaceShip());
    Room finish = new Room(0, desc.commandBridge());
    Room startRoom = new Room(0, desc.startRoom());
    Room room1 = new Room(r.nextInt(100) + 1, desc.hallWay1());
    Room room2 = new Room(r.nextInt(100) + 1, desc.hallWay3());
    Room room3 = new Room(r.nextInt(100) + 1, desc.dinningRoom());
    Room room4 = new Room(r.nextInt(100) + 1, desc.closet());
    Room room5 = new Room(r.nextInt(100) + 1, desc.kitchen());
    Room room6 = new Room(r.nextInt(100) + 1, desc.hallWay3());
    Room room7 = new Room(r.nextInt(100) + 1, desc.deadGarden());
    Room room8 = new Room(r.nextInt(100) + 1, desc.hallWay3());
    Room room9 = new Room(r.nextInt(100) + 1, desc.cross());
    Room room10 = new Room(r.nextInt(100) + 1, desc.hallWay1());
    Room room11 = new Room(r.nextInt(100) + 1, desc.hallWay2());
    Room room12 = new Room(r.nextInt(100) + 1, desc.hallWay2());
    Room room13 = new Room(r.nextInt(100) + 1, desc.hallWay2());
    Room room14 = new Room(r.nextInt(100) + 1, desc.hallWay3());
    Room room15 = new Room(r.nextInt(100) + 1, desc.officersLounge());
    Room room16 = new Room(r.nextInt(100) + 1, desc.hallWay3());
    Room room17 = new Room(r.nextInt(100) + 1, desc.hallWay3());
    Room room18 = new Room(r.nextInt(100) + 1, desc.lab());
    Room room19 = new Room(r.nextInt(100) + 1, desc.closet());

//    
    /**
     * Starts the application
     */
    public void start() throws InterruptedException {
        go();
        b.welcomeToGame();
        p.setName(b.createName());
        game();

    }

    /**
     * Creating connection of Rooms and The Dungeon
     */
    public void go() {
        //Map and Room direction rules
        startRoom.setNorth(room1);
        startRoom.setSouth(spaceShip);

        room1.setWest(room2);
        room1.setEast(room3);
        room1.setSouth(startRoom);

        room2.setEast(room1);
        room2.setWest(room9);
        room2.setTaxCollector(1);

        room3.setWest(room1);
        room3.setNorth(room5);
        room3.setSouth(room4);

        room4.setNorth(room3);

        room5.setNorth(room8);
        room5.setEast(room6);
        room5.setSouth(room3);

        room6.setNorth(room7);
        room6.setEast(room14);
        room6.setWest(room5);

        room7.setNorth(room15);
        room7.setEast(room8);
        room7.setSouth(room6);

        room8.setEast(room7);
        room8.setSouth(room5);

        room9.setNorth(room13);
        room9.setEast(room2);
        room9.setWest(room12);
        room9.setSouth(room10);

        room10.setNorth(room9);
        room10.setWest(room11);

        room11.setNorth(room12);
        room11.setEast(room10);

        room12.setEast(room9);
        room12.setSouth(room11);

        room13.setSouth(room9);
        room13.setEast(room14);

        room14.setEast(room6);
        room14.setWest(room13);

        room15.setEast(room17);
        room15.setWest(room16);
        room15.setSouth(room7);

        room16.setSouth(finish);
        room16.setEast(room15);

        room17.setEast(room18);
        room17.setWest(room15);

        room18.setWest(room17);
        room18.setSouth(room19);

        room19.setNorth(room18);
        room19.setTaxCollector(1);

    }

    /**
     * Manages game, movement form room, to next room, checks for winning room,
     * collection of gold.
     */
    public void game() throws InterruptedException {
        boolean checkVictory = true;
        currentRoom = startRoom;
        System.out.println(currentRoom.toString());
        Thread.sleep(500);
        while (checkVictory) {
            Thread.sleep(500);

            if (currentRoom.equals(finish)) {
                System.out.println(finish.getDescription());
                System.out.println(p.toString());
                System.out.println("You won");
                checkVictory = false;
            } else if (currentRoom.equals(spaceShip)) {
                System.out.println(p.toString());
                System.out.println("You chose to return to your ship");
                checkVictory = false;
            } else {
                currentRoom = playerAction(currentRoom);

            }
        }
    }
/**
 * When the player choose to collect the money in the room, and modifies the player
 * gold entity
 */
    public void collectGold() {
        int gold = currentRoom.getGold();
        String pickup = "";

        if (gold > 0) {
            System.out.println("In this room you find " + gold + " Space dollars");
            pickup = b.takeGold();
            if (pickup.equalsIgnoreCase("yes")) {
                p.setBank(gold);
                currentRoom.setGold(0);
            }

        } else {
            System.out.println("\nThere are no Space dollars in here");
        }
    }
/**
 * Manages the players action input. The method is set up to print out all the
 * possible directions in the currentRoom. It then returns a new room to place 
 * the player in.
 * @param currentRoom
 * @return 
 */
    public Room playerAction(Room currentRoom) {
        boolean takingAction = true;
        Room tempRoom = currentRoom;
        int taxCollector;
        while (takingAction) {

            String action = b.chooseAction();

            switch (action) {
                case "inspect":

                    System.out.println(currentRoom.toString());
                    taxCollector = currentRoom.getTaxCollector();
                    if (taxCollector == 1) {
                        taxRobot();

                    }

                    currentRoom.availableDirections();
                    break;

                case "search":
                    collectGold();
                    break;

                case "north":
                    if (action.equalsIgnoreCase("north") && currentRoom.getNorth() != null) {
                        System.out.println("\nYou went North");
                        tempRoom = currentRoom.getNorth();
                        takingAction = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;

                case "south":
                    if (action.equalsIgnoreCase("south") && currentRoom.getSouth() != null) {
                        System.out.println("\nYou went South");
                        tempRoom = currentRoom.getSouth();
                        takingAction = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;
                case "east":
                    if (action.equalsIgnoreCase("east") && currentRoom.getEast() != null) {
                        System.out.println("\nYou went East");
                        tempRoom = currentRoom.getEast();

                        takingAction = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;

                case "west":
                    if (action.equalsIgnoreCase("west") && currentRoom.getWest() != null) {
                        System.out.println("\nYou went West");
                        tempRoom = currentRoom.getWest();
                        takingAction = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;
                case "help":
                    b.helpCommand();
                    break;

                case "bank":
                    System.out.print("Your current Bank balance is:");
                    System.out.println(p.getBank() + "$");
                    break;
                case "exit":
                    tempRoom = spaceShip;
                    takingAction = false;
                    break;
                default: System.out.println("Nothing happend");    
            }
        }
        return tempRoom;
    }

    /**
     * Interacts with the taxCollector. After a checking if there is a tax collector in the room
     * this method runs the possible outcomes of this encounter based on player input.
     */
    public void taxRobot() {

        b.taxCollectorMeeting();
        boolean interaction = true;
        ////////////////////////////////////////////
        while (interaction) {
            String choice = b.chooseAction();
            if (p.getBank() > 20) {

                if (choice.equalsIgnoreCase("pay")) {
                    System.out.println("You pay the robot and he looks satisfied");
                    System.out.println("The Robot powers down.The robot should no longer be a problem");
                    currentRoom.setTaxCollector(0);

                    interaction = false;
                } else if (choice.equalsIgnoreCase("deny")) {
                    currentRoom.setGold(p.getBank());
                    p.setBank(-p.getBank());
                    p.setHp(-20);
                    System.out.println("The Robot bitchslaps you, and steals all your money. you now have " + p.getHp() + "HP");
                    System.out.println("The Robot powers down, and drops its moeny\nThe robot should no longer be a problem");
                    currentRoom.setTaxCollector(0);
                    interaction = false;
                } else {
                    System.out.println("Nothing happend");
                }

            } else if (choice.equalsIgnoreCase("help")) {
                b.helpCommand();
            } else if (choice.equalsIgnoreCase("pay")|| choice.equalsIgnoreCase("deny")&& p.getBank() < 20) {
                currentRoom.setGold(p.getBank());
                System.out.println("You were unable to pay the Robot");
                p.setHp(-20);
                System.out.println("The Robot bitchslaps you, you now have " + p.getHp() + "HP");
                System.out.println("The Robot powers down, and drops its moeny\nThe robot should no longer be a problem");
                currentRoom.setTaxCollector(0);
                interaction = false;
            } else {
                System.out.println("Nothing happend");
            }
            //////////////////////////////////////////////////
        }
    }
}
