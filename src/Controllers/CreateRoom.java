/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Enteties.Player;
import Enteties.Room;
import MonsterTypes.CorruptedWiers;
import MonsterTypes.Lurker;
import MonsterTypes.Monster;
import MonsterTypes.Styhr;
import MonsterTypes.Boss;
import MonsterTypes.Plants;
import MonsterTypes.PossessedChef;
import items.KeyItem;
import items.Weapon;
import items.Iitem;
import items.Armor;
import items.Potion;
import java.util.Random;

/**
 * This class creates rooms and items. Afterwards the class combines the rooms
 * and distributes items, traps and monsters
 *
 * @author thomas
 */
public class CreateRoom {
    
    // the rooms get made with the random gold and description 
    Random r = new Random();
    Room spaceShip = new Room(0, spaceShip());
    Room finish = new Room(0, commandBridge());
    Room startRoom = new Room(0, startRoom());
    Room room1 = new Room(r.nextInt(10)+5, hallWay1());
    Room room2 = new Room(r.nextInt(21), hallWay3());
    Room room3 = new Room(r.nextInt(21), dinningRoom());
    Room room4 = new Room(r.nextInt(21), closet());
    Room room5 = new Room(r.nextInt(21), kitchen());
    Room room6 = new Room(r.nextInt(51) + 20, barracks());
    Room room7 = new Room(r.nextInt(51) + 20, deadGarden());
    Room room8 = new Room(r.nextInt(51) + 20, hallWay3());
    Room room9 = new Room(r.nextInt(51) + 20, cross());
    Room room10 = new Room(r.nextInt(51) + 20, hallWay1());
    Room room11 = new Room(r.nextInt(51) + 20, hallWay2());
    Room room12 = new Room(r.nextInt(51) + 20, hallWay2());
    Room room13 = new Room(r.nextInt(51) + 20, hallWay2());
    Room room14 = new Room(r.nextInt(51) + 20, hallWay3());
    Room room15 = new Room(r.nextInt(51) + 50, officersLounge());
    Room room16 = new Room(r.nextInt(101) + 30, hallWay3());
    Room room17 = new Room(r.nextInt(101) + 30, hallWay3());
    Room room18 = new Room(r.nextInt(101) + 30, lab());
    Room room19 = new Room(r.nextInt(101) + 30, hallWay2());


    // Weapons
    // The weapons are made with name, description and dmg.
    Iitem gun = new Weapon("Small Laserpistol", "PewPewPew", 2);
    Iitem laserBlade = new Weapon("Laser blade", "This can be used too all kinds of things, even making food", 4);
    Iitem darlekRifle = new Weapon("Darlek Rifle", "This Rifle is build from a Darlek's laser shooter", 14);
    Iitem particlelRemovalMop = new Weapon("Particle removal mop", "Just a normal hightech mop, but you can still hit things with it", 1);
    Iitem sonicSwordOfTheWhisperMen = new Weapon("Sonic sword of The Whisper Men", "A Sword that makes a sonic vibration which sounds like a whisper", 13);
    Iitem plasmaRifle = new Weapon("Plasma Rifle", "Fires a plasma discharge in the form of a beam", 6);
    Iitem blaster = new Weapon("Blaster", "This blaster was once owned by a guy called Han", 17);
   // Iitem godBlaster = new Weapon("God Blaster", "This blaster was once owned by GOD", 2000);

    //Armors
    // The armors are made with name, description and defence.
    Iitem spaceSuit = new Armor("Space Suit", "Standard issued space suit", 1);
    Iitem improvedSpaceSuit = new Armor("Guards Space Suit", "Standard issued military armor", 5);
    Iitem beatUpEngineeringSpaceSuit = new Armor("Beat up engineering space suit", "This old suit have taken alot of damage, and is bearly holding it self together", 2);
    Iitem cybermanArmor = new Armor("Cyberman Armor", "You will be upgraded", 10);
    Iitem gardenersArmor = new Armor("Gardeners Armor", "Its a heavily armored suit, that has alot of bitemarks all over it", 4);
    Iitem officersUniform = new Armor("Officers Uniform", "This uniform creates a small force field around it's wearer, that protects the wearer from harm", 7);
    Iitem labCoat = new Armor("Lab Coat", "This lab coat is just a normal lab coat with many strange things spilled on it", 1);

    //Potions  
    //Potions have a name, description and tier for what kind of potion it is 
   Iitem p3 = new Potion("Super Stimpack", "Restores 30 HP", 3);
   Iitem p2 = new Potion("Medium Stimpack", "Restores 20 HP", 2);
   Iitem p1 = new Potion("Small Stimpack", "Restores 10 HP", 1);
   Iitem c1 = new Potion("A Moldy Space Chicken", "The Chicken looks strangely green", 4);
   
    //Misc items
   //Fun items don't realy do anything.
    Iitem gameSpaceCrawler = new KeyItem("The game SPACE CRAWLER cause Space Invaders was already taken", "");
    Iitem mapFloor1= new KeyItem("old datapad", "The Datapad shows a map: Dinningroom > Kitchen > Botanic Garden > Officer Lounge > Left > Command Bridge");

    // ****** CREATE MONSTERS ****** //
    // TIER 1 MONSTERS (NAME, HP, DAMAGE, ARMOR, TIER, GOLD)
    Monster spaceWier = new CorruptedWiers("Wier", 4, 3, 0,  r.nextInt(10)+5);
    Monster spaceWier2 = new CorruptedWiers("Wier", 4, 3, 0,  r.nextInt(10)+5);
    Monster spaceWier3 = new CorruptedWiers("Wier", 4, 3, 0,  r.nextInt(10)+5);
    Monster spaceWier4 = new CorruptedWiers("Wier", 4, 3, 0,  r.nextInt(10)+5);
    Monster mutatedSpaceWier4 = new CorruptedWiers("Giant Mutated Space Wier", 8, 6, 2,  r.nextInt(20)+5);
    Monster killerPlant = new Plants("Evil Killer PLant", 10, 6, 6, 0);
            
    Monster possessedChef = new PossessedChef("Parasite Possessed Chef", 10, 4, 1, r.nextInt(15)+5);
    Monster commonLurker = new Lurker("Common Lurker", 5, 3, 0,  5);
    Monster patheticLurker = new Lurker("Pathetic Lurker", 1, 1, 0,  5);
    
    
    //TIER 2 MONSTERS (NAME, HP, DAMAGE, ARMOR, TIER, gold)
    Monster slasher = new Styhr("Slasher", 5, 10, 7,  30);
    

    //TIER 3 BOSS MONSTERS (NAME, HP, DAMAGE, ARMOR, TIER, gold)
    Monster WierCorruptedGeneral = new Boss("Wier Corrupted General", 60, r.nextInt(5) + 21, r.nextInt(5),  r.nextInt(150) + 70);
    Monster CorruptedOfficer = new Boss("A corrupted Officer", 15, r.nextInt(5)+9, 3,  r.nextInt(70) + 70);
    
    /**
     * Adds the directions, the items, and monster to the different rooms.
     */
    public void roomFeatures() {
        //Map and Room direction rules
        
        
        //Start room
        startRoom.setNorth(room1);
        startRoom.setSouth(spaceShip);

        
        
        
        //Room 1 directions
        room1.setWest(room2);
        room1.setEast(room3);
        room1.setSouth(startRoom);
        //Room 1 items
        room1.add(p1);
        
        
        
        //Room 2 directions
        room2.setEast(room1);
        room2.setWest(room9);
      
        
        //Room 3 (Dinning Room)directions
        room3.setWest(room1);
        room3.setNorth(room5);
        room3.setSouth(room4);
        //Room 3 loot
        room3.add(c1);
        //Room 3 monsters
        room3.setMonster(spaceWier);
        //Monster loot
        spaceWier.addLoot(p1);
        
        
        //Room 4 Directions
        room4.setNorth(room3);
        //Room 4 Items
        room4.add(beatUpEngineeringSpaceSuit);
        room4.add(particlelRemovalMop);
       

        //Room 5 (Kitchen) directions
        room5.setNorth(room8);
        room5.setWest(room6);
        room5.setSouth(room3);
        //Room 5 monster
        room5.setMonster(possessedChef);
        //Monster loot
        possessedChef.addLoot(laserBlade);
     
        
        //room 6 (Barracks) directions
        room6.setNorth(room7);
        room6.setWest(room14);
        room6.setEast(room5);
        //Room 6 Traps
        room6.setTrap(1);
        //room 6 loot
        room6.add(darlekRifle);
        room6.add(plasmaRifle);
        
        
        
        
        //Room 7 (Botanic Garden) directions
        room7.setNorth(room15);
        room7.setEast(room8);
        room7.setSouth(room6);
        //Room 7 monster
        room7.setMonster(killerPlant);
        //Room 7 monster loot
        killerPlant.addLoot(p3);
        //Room 7 loot
        room7.add(p3);
        room7.add(p3);
        room7.add(gardenersArmor);
       
        //Room 8 directions
        room8.setWest(room7);
        room8.setSouth(room5);

        
        //Room 9 directions
        room9.setNorth(room13);
        room9.setSouth(room10);
        room9.setEast(room2);
        room9.setWest(room12);
        //Traps
        room9.setTaxCollector(1);

        
        
        //Room 10 directions
        room10.setNorth(room9);
        room10.setWest(room11);
        //Room 10 loot
        room10.add(p2);
        //Room 10 Monsters
        room10.setMonster(spaceWier2);
        
        
        
        
        //Room 11 directions
        room11.setNorth(room12);
        room11.setEast(room10);
        //Room 11 traps
        room11.setTrap(1);
      
        
        //Room 12 directions
        room12.setEast(room9);
        room12.setSouth(room11);
        //Room 12 Monsters
        room12.setMonster(commonLurker);
        //Monster loot
        commonLurker.addLoot(mapFloor1);
        
        //Room 13 directions
        room13.setSouth(room9);
        room13.setEast(room14);
        //Room 13 Monster
        room13.setMonster(spaceWier3);
        //Room traps
        room13.setTrap(1);
        
        //Room 14 directions
        room14.setEast(room6);
        room14.setWest(room13);
        //Room 14 traps
        room14.setTaxCollector(0);
        
        
        //Room 15 (Officers Lounge) directions
        room15.setEast(room17);
        room15.setWest(room16);
        room15.setSouth(room7);
        //Room 15 Monsters
        room15.setMonster(CorruptedOfficer);
        //Monster Loot
        CorruptedOfficer.addLoot(darlekRifle);
        CorruptedOfficer.addLoot(officersUniform);
        CorruptedOfficer.addLoot(p3);
        CorruptedOfficer.addLoot(p3);
        
        //Room 16 directions
        room16.setSouth(finish);
        room16.setEast(room15);
        //Room 16 Traps
        room16.setTrap(1);

        
        
        //room 17 directions
        room17.setEast(room18);
        room17.setWest(room15);
       
        //Room 18 (Lab) directions
        room18.setWest(room17);
        room18.setSouth(room19);
        //Room 18 Monsters
        room18.setMonster(mutatedSpaceWier4);
        //Room 18 Loot
        room18.add(labCoat);
        room18.add(sonicSwordOfTheWhisperMen);
        
        
        //Room19 (closet) directions
        room19.setNorth(room18);
        //Room19 Loot
        room19.add(c1);
        room19.add(c1);
        room19.add(c1);
        
        //Room Finish directions
        finish.setNorth(room16);
        //Room finish Monsters
        finish.setMonster(WierCorruptedGeneral);
        //Room Finish Loot
        WierCorruptedGeneral.addLoot(gameSpaceCrawler);
    

    }
    /**
     * Adds items, to player inventory and to player equipped items.
     * @param player 
     */
    public void addPlayerStartItems(Player player) {
        player.addItemToInventory(gun);
        player.addItemToInventory(spaceSuit);
        player.addItemToInventory(p1);
        player.addItemToInventory(p1);
        player.checkInventoryAndEquip("Small Laserpistol");
        player.checkInventoryAndEquip("Space Suit");
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
                + "__________________________________________________________________\n";

        return desc;
    }
    //Bruges på rum 20

    public String commandBridge() {
        String desc = "\n=== Command Bridge ===\n"
                + "You finally enter the Command Bridge.\n"
                + "Here you find the dead body of the former captain of the station\n"
                + "You look over his corpse and find what you came for....\n"
                + "The prerelease copy of the famous game.\n"
                + "SPACE CRAWLER: CAUSE SPACE INVADERS WAS ALREADY TAKEN\n"
                + "__________________________________________________________________\n";

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
                + "__________________________________________________________________\n";
        return desc;
    }

    //Bruges på room 6
    public String barracks() {

        String desc = "\n=== BARRACKS ==\n"
                + "You entered the sleeping area\n"
                + "Its litteraly a mess...\n"
                + "You look around and find frozen corpses floating around\n"
                + "in one of the room corners.\n"
                + "__________________________________________________________________\n";
        return desc;
    }

    ///Bruges på rum 3
    public String dinningRoom() {

        String desc = "\n=== DINNING ROOM ==\n"
                + "You entered a large dinning hall.\n"
                + "Tabels are floating around and it is mostly in ruin.\n"
                + "There is half a kitchen robot floating around\n"
                + "there is also a frozen buffet scattered all over the place.\n"
                + "__________________________________________________________________\n";
        return desc;
    }

    //Bruges på rum 15
    public String officersLounge() {

        String desc = "\n=== OFFICERS LOUNGE ==\n"
                + "You enter a pretty decent room\n"
                + "the room looks more classy than the other rooms\n"
                + "obviously it is somekind of officer lounge,\n"
                + "there is nothing in paticular here.\n"
                + "__________________________________________________________________\n";
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
                + "You enter the ships lab the first thing you see, is the surprising lack of dust in the room,\n"
                + "and the weird wiers that spark all over the place.\n"
                + "__________________________________________________________________\n";

        return desc;
    }

}
