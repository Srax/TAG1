/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Random;

/**
 *
 * @author thoma
 */
public class CreateRoom {
    Description desc = new Description();
    Random r = new Random();
    
    
    Room spaceShip = new Room(0, desc.spaceShip());
    Room finish = new Room(0, desc.commandBridge());
    Room startRoom = new Room(0, desc.startRoom());
    Room room1 = new Room(r.nextInt(101), desc.hallWay1());
    Room room2 = new Room(r.nextInt(101), desc.hallWay3());
    Room room3 = new Room(r.nextInt(101), desc.dinningRoom());
    Room room4 = new Room(r.nextInt(101), desc.closet());
    Room room5 = new Room(r.nextInt(101), desc.kitchen());
    Room room6 = new Room(r.nextInt(101), desc.hallWay3());
    Room room7 = new Room(r.nextInt(101), desc.deadGarden());
    Room room8 = new Room(r.nextInt(101), desc.hallWay3());
    Room room9 = new Room(r.nextInt(101), desc.cross());
    Room room10 = new Room(r.nextInt(101), desc.hallWay1());
    Room room11 = new Room(r.nextInt(101), desc.hallWay2());
    Room room12 = new Room(r.nextInt(101), desc.hallWay2());
    Room room13 = new Room(r.nextInt(101), desc.hallWay2());
    Room room14 = new Room(r.nextInt(101), desc.hallWay3());
    Room room15 = new Room(r.nextInt(51)+50, desc.officersLounge());
    Room room16 = new Room(r.nextInt(101), desc.hallWay3());
    Room room17 = new Room(r.nextInt(101), desc.hallWay3());
    Room room18 = new Room(r.nextInt(101), desc.lab());
    Room room19 = new Room(r.nextInt(101), desc.closet());
    
    public void roomFeatures() {
        //Creates the Rooms as individual objects
        //Map and Room direction rules
        startRoom.setNorth(room1);
        startRoom.setSouth(spaceShip);

        room1.setWest(room2);
        room1.setEast(room3);
        room1.setSouth(startRoom);
        room1.setTrap(1);
        
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
}
