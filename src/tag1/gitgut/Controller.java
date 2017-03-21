
package tag1.gitgut;

import java.util.Random;

public class Controller {
    Boundry b = new Boundry();
    Random r = new Random();
    Player p = new Player();
    Description desc = new Description();
    boolean flag;
    
        //Creates the Rooms as individual objects
        Room startRoom = new Room(r.nextInt(100)+1,desc.startRoom());
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
    
    public void start() {
        go();
        b.welcomeToGame();
        b.createName();
    //    int hp = p.getHp();
        
//        while(flag = true){
//            System.out.println(startRoom.getDiscription());
//            String choice = b.playerDirection();
//            room1.Direction(choice);
//            
//        }
    }
    
    /**
    * Creating of Rooms and The Dungeon
    */
    public void go(){
    //Map and Room direction rules
    startRoom.setNorth(room1);
    //startRoom.setSouth();
        
    room1.setWest(room2);
    room1.setEast(room3);
    room1.setSouth(startRoom);
    
    room2.setEast(room1);
    room2.setWest(room9);
    
    room3.setEast(room1);
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
    
    room16.setSouth(room20);
    
    room17.setEast(room18);
    room17.setWest(room15);
    
    room18.setWest(room17);
    room18.setSouth(room19);
    
    room19.setNorth(room18);
    
    }
}








        
    

