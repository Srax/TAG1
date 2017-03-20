/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

import java.util.Random;

/**
 *
 * @author Stanislav
 */
public class Controller {
    Random r = new Random();
    Description desc = new Description();
    public void go(){
    Room startRoom = new Room(r.nextInt(100)+1, desc.startRoom());
    Room room1 = new Room(r.nextInt(100)+1,desc.hallWay1());
    Room room2 = new Room(r.nextInt(100)+1,desc.hallWay1());
    Room room3 = new Room(r.nextInt(100)+1,desc.hallWay2());
    Room room4 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room5 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room6 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room7 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room8 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room9 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    
    Room room10 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room11 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room12 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room13 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room14 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room15 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room16 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room17 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room18 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room19 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    //Goal Room
    Room room20 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    
    startRoom.setEast(room1);
    //startRoom.setSouth();
    
    room1.setSouth(startRoom);
    room1.setWest(room2);
    room1.setEast(room3);
    
    room2.setEast(room1);
    room2.setWest(room9);
    
    room3.setEast(room1);
    room3.setNorth(room5);
    room3.setSouth(room5);
    
    room4.setNorth(room3);
    
    room5.setNorth(room8);
    room5.setEast(room6);
    room5.setSouth(room3);
    
    room6.setNorth(room7);
    room6.setEast(room14);
    room6.setWest(room5);
    
    room7.setNorth(room15);
    room7.setWest(room8);
    room7.setSouth(room6);
    
    room8.setEast(room7);
    room8.setSouth(room5);
    
    room8.setSouth(room5);
    
    
    
    
    
    
    }
}








        
    

