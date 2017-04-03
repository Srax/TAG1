/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import MonsterTypes.CorruptedWiers;
import MonsterTypes.Monster;
import MonsterTypes.Plants;
import items.KeyItem;
import items.Weapon;
import items.Iitem;
import items.Armor;
import items.Potion;
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
    
    
    // Items that will be created weapons
    Iitem gun = new Weapon("Small Laserpistol", "PewPewPew", 2);   
    Iitem laserBlade = new Weapon("Laser blade", "This can be used too all kinds of things, even making food", 4);
    Iitem darlekRifle = new Weapon("Darlek Rifle", "This Rifle is build from a Darlek's laser shooter", 14);
    Iitem particlelRemovalMop = new Weapon("Particle removal mop", "Just a normal hightech mop, but you can still hit things with it", 1);
    Iitem sonicSwordOfTheWhisperMen = new Weapon("Sonic sword of The Whisper Men", "A Sword that makes a sonic vibration which sounds like a whisper", 13);
    Iitem plasmaCannon = new Weapon("Plasma Cannon", "Fires a plasma discharge in the form of a beam", 6);
    Iitem hanBlaster = new Weapon("Han's Blaster", "This blaster was once owned by a guy called Han", 17);
    
    //Armors
    Iitem SpaceSuit = new Armor("Space Suit", "Standard issued space suit", 1);
    Iitem beatUpEngineeringSpaceSuit = new Armor("Beat up engineering space suit", "This old suit have taken alot of damage, and is bearly holding it self together", 2);
    Iitem cybermanArmor = new Armor("Cyberman Armor", "You will be upgraded", 10);
    Iitem gardenersArmor = new Armor("Gardeners Armor", "Its a heavily armored suit, that has alot of bitemarks all over it", 5);
    Iitem officersUniform = new Armor("Officers Uniform", "This uniform creates a small force field around it's wearer, that protects the wearer from harm", 7);
    Iitem labCoat = new Armor("Lab Coat", "This lab coat is just a normal lab coat with many strange things spilled on it", 1);
    //Potions  
    Iitem p3 = new Potion("Super Stimpack", "Increases HP with 30",3);
    Iitem p2 = new Potion("Medium Stimpack", "Increases HP with 20",2);
    Iitem p1 = new Potion("Small Stimpack", "Increases Hp with 10",1);
    
    //Misc items
    Iitem gameSpaceCawler = new KeyItem("The Game SPACE CAWLER", "Cause Space Invaders was already taken");
    
    
    //CREATE MONSTERS
    Monster spaceWier = new CorruptedWiers("Wiers", 10, 5, 2, 1);
    Monster spaceRoses = new Plants("Space Roses", 30, 10, 10, 3);
    
    public void roomFeatures() {
        //Map and Room direction rules
        
        startRoom.setNorth(room1);
        startRoom.setSouth(spaceShip);
        startRoom.loot.add(p1);
        startRoom.setMonster(spaceWier);
        
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
        room4.add(beatUpEngineeringSpaceSuit);
        room4.add(particlelRemovalMop);

        room5.setNorth(room8);
        room5.setWest(room6);
        room5.setSouth(room3);
        room5.add(laserBlade);
        room5.add(p2);

        room6.setNorth(room7);
        room6.setWest(room14);
        room6.setEast(room5);
        room6.setTrap(1);
        room6.add(darlekRifle);
        room6.add(plasmaCannon);
        room6.add(gardenersArmor);
        
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
        room11.add(sonicSwordOfTheWhisperMen);
        
        room12.setEast(room9);
        room12.setSouth(room11);
        room12.add(p3);
        
        room13.setSouth(room9);
        room13.setEast(room14);

        room14.setEast(room6);
        room14.setWest(room13);

        room15.setEast(room17);
        room15.setWest(room16);
        room15.setSouth(room7);
        room15.setTrap(1);
        room15.add(officersUniform);
        room15.add(hanBlaster);
        
        room16.setSouth(finish);
        room16.setEast(room15);

        room17.setEast(room18);
        room17.setWest(room15);
        room17.add(p1);
        
        room18.setWest(room17);
        room18.setSouth(room19);
        room18.add(labCoat);
        room18.add(cybermanArmor);
        
        room19.setNorth(room18);
        room19.setTaxCollector(1);
        
        finish.add(gameSpaceCawler);
    
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
