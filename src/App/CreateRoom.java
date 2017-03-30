/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Random;

/**
 *This class creates rooms and items.
 * Afterwards the class combines the rooms and distributes items, traps and monsters
 * @author thoma
 */
public class CreateRoom {
    
    Random r = new Random();
    
    
    Room spaceShip = new Room(0, spaceShip());
    Room finish = new Room(0, commandBridge());
    Room startRoom = new Room(0, startRoom());
    Room room1 = new Room(r.nextInt(101), hallWay1());
    Room room2 = new Room(r.nextInt(101), hallWay3());
    Room room3 = new Room(r.nextInt(101), dinningRoom());
    Room room4 = new Room(r.nextInt(101), closet());
    Room room5 = new Room(r.nextInt(101), kitchen());
    Room room6 = new Room(r.nextInt(101), barracks());
    Room room7 = new Room(r.nextInt(101), deadGarden());
    Room room8 = new Room(r.nextInt(101), hallWay3());
    Room room9 = new Room(r.nextInt(101), cross());
    Room room10 = new Room(r.nextInt(101), hallWay1());
    Room room11 = new Room(r.nextInt(101), hallWay2());
    Room room12 = new Room(r.nextInt(101), hallWay2());
    Room room13 = new Room(r.nextInt(101), hallWay2());
    Room room14 = new Room(r.nextInt(101), hallWay3()); 
    Room room15 = new Room(r.nextInt(51)+50, officersLounge());
    Room room16 = new Room(r.nextInt(101), hallWay3());
    Room room17 = new Room(r.nextInt(101), hallWay3());
    Room room18 = new Room(r.nextInt(101), lab());
    Room room19 = new Room(r.nextInt(101), closet());
    
    
    // Items that will be created
    Iitem gun = new Weapon("Small Laserpistol", "PewPewPew", 5);
    Iitem monkey= new Weapon("Monkey", "Bananas thrown by Pro banana tosser", 1);
    Iitem monkeySuit = new Armor("Monkey Suit", "Makes you look like a Space-monkey", 10);
    Iitem p3 = new Potion("Super Stimpack", "Makes you feel nice",3);
    Iitem p2 = new Potion("Medium Stimpack", "Makes you feel not nearly so nice",2);
    Iitem p1 = new Potion("Small Stimpack", "Makes you feel not nearly so nice",1);

    
/**
 * The method connect the rooms created. Planning out the dungeon and placing items.
 * 
 */
    public void roomFeatures() {
        //Creates the Rooms as individual objects
        //Map and Room direction rules
        
        startRoom.setNorth(room1);
        startRoom.setSouth(spaceShip);
        startRoom.loot.add(gun);
        startRoom.loot.add(monkey);
        startRoom.loot.add(monkeySuit);
        startRoom.loot.add(p1);
        startRoom.loot.add(p2);
        startRoom.loot.add(p3);
        
        room1.setWest(room2);
        room1.setEast(room3);
        room1.setSouth(startRoom);
        room1.loot.add(p2);
        
        
        
        room2.setEast(room1);
        room2.setWest(room9);
        room2.setTaxCollector(1);

        room3.setWest(room1);
        room3.setNorth(room5);
        room3.setSouth(room4);

        room4.setNorth(room3);

        room5.setNorth(room8);
        room5.setWest(room6);
        room5.setSouth(room3);

        room6.setNorth(room7);
        room6.setWest(room14);
        room6.setEast(room5);
        room6.setTrap(1);
        
        room7.setNorth(room15);
        room7.setEast(room8);
        room7.setSouth(room6);

        room8.setWest(room7);
        room8.setSouth(room5);

        room9.setNorth(room13);
        room9.setSouth(room10);
        room9.setEast(room2);
        room9.setWest(room12);
        
        
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
        room15.setTrap(1);
        
        room16.setSouth(finish);
        room16.setEast(room15);

        room17.setEast(room18);
        room17.setWest(room15);

        room18.setWest(room17);
        room18.setSouth(room19);

        room19.setNorth(room18);
        room19.setTaxCollector(1);
        
        
        
    
    }
        public String startRoom() {

        String desc = "\n=== DUNGEON ENTRANCE ===\n"
                + "After a long journey from earth, you have finally docked at the\n"
                + "abandon spaceship that you were sent to find.\n"
                + "\n"
                + "The ship was lost during an exploration Mission from earth a few years prior.\n"
                + "The light is dim, and the atmosphere is cold around you as you decide to float\n"
                + "futher into the old metal wreck.\n"
                + "________________________________________________________________________________\n";
                
        return desc;
    }

    //hallWay1 bruges på rum 1, 10 ,
    public String hallWay1() {
        String desc = "\n=== HALLWAY ===\n"
                + "You enter a dark and silent hallway, broken wiers floats around \n"
                + "throwing sparks flying everywhere in the crammed space\n"
                + "There is noting of real intrest here.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }

    //Bruges på rum 11,12,13
    public String hallWay2() {
        String desc = "\n=== HALLWAY ===\n"
                + "Still a hallway.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }
    //Bruges på rum 4,19
    public String closet() {

        String desc = "\n=== CLOSET ==\n"
                + "You entered an old dirty closet...\n"
                + "The closet contains an wooden broom, a rusty bucket and some old rags.\n"
                + "There appears to be nothing of value in here, go back.\n"
                +"__________________________________________________________________\n";
                
        return desc;
    }
     //Bruges på rum 20
    public String commandBridge(){
        String desc = "\n=== Command Bridge ===\n"
                + "You finally enter the Command Bridge.\n"
                + "Here you find the dead body of the former captain of the station\n"
                + "You look over his corpse and find what you came for....\n"
                + "The prerelease copy of the famous game.\n"
                + "SPACE CRAWLER: CAUSE SPACE INVADERS WAS ALREADY TAKEN\n"
                +"__________________________________________________________________\n";
                
        return desc;
    
    
    }
    //Bruges på exit room
    public String spaceShip() {
        String desc = "\n=== Space Ship ===\n"
                + "You have returned to your spaceship.\n";
                
        return desc;        
    }
    //Bruges på room 7
    public String deadGarden() {

        String desc = "\n=== DEAD BOTANIC GARDEN ==\n"
                + "You entered an creepy dead garden\n"
                + "The Garden contains alot of plants you have never seen before\n"
                + "Some of the trees still appear to be alive\n"
                + ",that makes you wonder how without oxygen.\n"
                +"__________________________________________________________________\n";   
        return desc;
    }
    //Bruges på room 6
    public String barracks() {

        String desc = "\n=== BARRACKS ==\n"
                + "You entered the sleeping area\n"
                + "Its litteraly a mess...\n"
                + "You look around and find frozen corpses floating around\n"
                + "in one of the room corners.\n"
                +"__________________________________________________________________\n";   
        return desc;
    }
    ///Bruges på rum 3
    public String dinningRoom() {

        String desc = "\n=== DINNING ROOM ==\n"
                + "You entered a large dinning hall.\n"
                + "Tabels are floating around and it is mostly in ruin.\n"
                + "There is half a kitchen robot floating around\n"
                + "there is also a frozen buffet scattered all over the place.\n"
                +"__________________________________________________________________\n";   
        return desc;
    }
    //Bruges på rum 15
    public String officersLounge() {

        String desc = "\n=== OFFICERS LOUNGE ==\n"
                + "You enter a pretty decent room\n"
                + "the room looks more classy than the other rooms\n"
                + "obviously it is somekind of officer lounge,\n"
                + "there is nothing in paticular here.\n"
                +"__________________________________________________________________\n";   
        return desc;
    }
    //Bruges på rum 2,8,16,17
    public String hallWay3() {
        String desc = "\n=== HALLWAY ===\n"
                + "This is a dark and spooky hallway where the dust is thick.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }
    //Bruges på rum 9
    public String cross() {
        String desc = "\n=== HALLWAY CROSSROAD ===\n"
                + "Your at a crossroad there are 4 ways you can go choose wisely.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }
    //Bruges på rum 5
    public String kitchen() {
        String desc = "\n=== KITCHEN ===\n"
                + "Your at the ships kitchen rusted kitchen utensils,\n"
                + "are located in piles all over the room,\n"
                + "it looks like someone has stached it there.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }
    
    //Bruges på rum 18
    public String lab() {
        String desc = "\n=== LAbBOrRATORY ===\n"
                + "You inter the ships lab the first thing you see, is the surprising lack of dust in the room,\n"
                + "and the weird wiers that spark all over the place.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }
}
