/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

/**
 *
 * @author DD
 */
public class Description {

    Player p = new Player();

    public String startRoom() {

        String desc = "=== DUNGEON ENTRANCE ===\n"
                + "\n"
                + "After a long journey from earth, you have finally docked at the\n"
                + "abandon spaceship that you were sent to find.\n"
                + "\n"
                + "The ship was lost during an exploration Mission from earth a few years prior.\n"
                + "The light is dim, and the atmosphere is cold around you as you decide to float\n"
                + "futher into the old metal wreck.\n"
                + "________________________________________________________________________________\n"
                + "From this room you can go:\nNorth\nSouth";
        return desc;
    }

    //hallWay1 bruges på rum 1 og 2
    public String hallWay1() {
        String desc = "=== HALLWAY ===\n"
                + "You enter a dark and silent hallway, broken wiers floats around \n"
                + "throwing sparks flying everywhere in the crammed space\n"
                + "There is noting of real intrest here.\n"
                + "__________________________________________________________________\n"
                + "From this room you can\nEast\nWest\nSouth";
        return desc;
    }

    //Bruges på rum 3
    public String hallWay2() {
        String desc = "=== HALLWAY ===\n"
                + "Still a hallway.\n"
                + "__________________________________________________________________\n"
                + "From this hallway oyu can go:\nSouth\nWest";
        return desc;
    }

    public String closet() {

        String desc = "=== CLOSET ==\n"
                + "\n"
                + "You entered an old dirty closet...\n"
                + "The closet contains an wooden broom, a rusty bucket and some old rags.\n"
                + "There appears to be nothing of value in here, go back."
                +"__________________________________________________________________\n"
                + "From this hallway oyu can go:\nEast";
        return desc;
    }
    public String commandBridge(){
        String desc = "=== Command Bridge ===\n"
                + "You finally enter the Command Bridge.\n"
                + "Here you find the dead body of the former captain of the station\n"
                + "You look over his corpse and find what you came for....\n"
                + "The prerelease copy of the famous game.\n"
                + "SPACE CRAWLER: CAUSE SPACE INVADERS WAS ALREADY TAKEN"
                +"__________________________________________________________________\n"
                + "From this hallway oyu can go:\nNorth";;
        return desc;
    
    
    }
    
}
