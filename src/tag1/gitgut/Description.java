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
                + "You enter a dark and silent hallway, broken wiers floats around \n"
                + "throwing sparks flying everywhere in the crammed space\n"
                + "There is noting of real intrest here.\n"
                + "__________________________________________________________________\n"
                + "From this hallway oyu can go:\nWest\nEast";
        return desc;
        }

    public String closet() {

        String desc = "You enter a dark and scilent hallway, broken wires ";

        return desc;
    }
}
