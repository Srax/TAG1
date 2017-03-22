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
    Room room2 = new Room(r.nextInt(100) + 1, desc.closet());
    Room room3 = new Room(r.nextInt(100) + 1, desc.hallWay2());

//        Room room5 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room6 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room7 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room8 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room9 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room10 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room11 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room12 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room13 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room14 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room15 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room16 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room17 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room18 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room19 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
//        Room room20 = new Room(r.nextInt(100) + 1, "Start room, bla bla bla");
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
        room2.setTaxCollector(1);
        //room2.setWest(room9);

        room3.setEast(room1);
        //room3.setNorth(room5);
        room3.setSouth(finish);

        finish.setNorth(room3);

//        room5.setNorth(room8);
//        room5.setEast(room6);
//        room5.setSouth(room3);
//
//        room6.setNorth(room7);
//        room6.setEast(room14);
//        room6.setWest(room5);
//
//        room7.setNorth(room15);
//        room7.setEast(room8);
//        room7.setSouth(room6);
//
//        room8.setEast(room7);
//        room8.setSouth(room5);
//
//        room9.setNorth(room13);
//        room9.setEast(room2);
//        room9.setWest(room12);
//        room9.setSouth(room10);
//
//        room10.setNorth(room9);
//        room10.setWest(room11);
//
//        room11.setNorth(room12);
//        room11.setEast(room10);
//
//        room12.setEast(room9);
//        room12.setSouth(room11);
//
//        room13.setSouth(room9);
//        room13.setEast(room14);
//
//        room14.setEast(room6);
//        room14.setWest(room13);
//
//        room15.setEast(room17);
//        room15.setWest(room16);
//        room15.setSouth(room7);
//
//        room16.setSouth(room20);
//
//        room17.setEast(room18);
//        room17.setWest(room15);
//
//        room18.setWest(room17);
//        room18.setSouth(room19);
//
//        room19.setNorth(room18);
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

    public Room playerAction(Room currentRoom) {
        boolean flag = true;
        Room tempRoom = currentRoom;
        int taxCollector;
        while (flag) {

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
                        flag = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;

                case "south":
                    if (action.equalsIgnoreCase("south") && currentRoom.getSouth() != null) {
                        System.out.println("\nYou went South");
                        tempRoom = currentRoom.getSouth();
                        flag = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;
                case "east":
                    if (action.equalsIgnoreCase("east") && currentRoom.getEast() != null) {
                        System.out.println("\nYou went East");
                        tempRoom = currentRoom.getEast();

                        flag = false;

                    } else {
                        System.out.println("You are trying to walk into a wall");

                    }
                    break;

                case "west":
                    if (action.equalsIgnoreCase("west") && currentRoom.getWest() != null) {
                        System.out.println("\nYou went West");
                        tempRoom = currentRoom.getWest();
                        flag = false;

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
                    flag = false;
                    break;

            }
        }
        return tempRoom;
    }

    public void taxRobot() {

        b.taxCollectorMeeting();
        String choice = b.chooseAction();
        if (p.getBank() > 20) {
            if (choice.equalsIgnoreCase("pay")) {
                p.setBank(-20);
                currentRoom.setTaxCollector(0);
            } else if (choice.equalsIgnoreCase("deny")) {
                p.setHp(-20);
                System.out.println("The Robot bitchslaps you, you now have " + p.getHp() + "HP");
                System.out.println("The Robot powers down, and should no longer be a problem");
                currentRoom.setTaxCollector(0);

            }

        } else if (choice.equalsIgnoreCase("pay") && p.getBank() < 20) {
            System.out.println("You were unable to pay the Robot");
            p.setHp(-20);
            System.out.println("The Robot bitchslaps you, you now have " + p.getHp() + "HP");
            System.out.println("The Robot powers down, and should no longer be a problem");
            currentRoom.setTaxCollector(0);
        } else {
            
        }
    }
}
