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
    public void go(){
    Room startRoom = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room1 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room2 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    Room room3 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
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
    Room room20 = new Room(r.nextInt(100)+1,"Start room, bla bla bla");
    
        System.out.println(room8.toString());
        System.out.println(room1.toString());
    startRoom.setEast(room1);
    
    room1.setWest(startRoom);
    }
}
