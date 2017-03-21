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

    public String startRoom() {
        return "=== DUNGEON ENTRANCE ===\n"
                + "\n"
                + "After a Long journey from earth, you have finally docked at the\n"
                + "abandond spaceship that you were sent to find.\n"
                + "\n"
                + "The ship was lost during an exploration Mission from earth a few years prior.\n"
                + "The light is dim, and the atmosphere is cold around you as you decide to float\n"
                + "futher into the old metal wreck.\n"
                + "________________________________________________________________________________\n"
                + "From this room you can go:\nEast\nWest\nSouth";

    }
    //hallWay1 bruges på rum 1 og 2
    public String hallWay1() {
        return "=== HALLWAY ===\n"
                + "You enter a dark and silent hallway, broken wiers floats around \n"
                + "throwing sparks flying everywhere in the crammed space\n"
                + "There is noting of real intrest here.\n"
                + "__________________________________________________________________\n"
                + "From this hallway you can go:\nWest\nEast";

    }
    
    //Bruges på rum 3
    public String hallWay2(){
        return "=== HALLWAY ===\n"
                + "You enter a dark and silent hallway, broken wiers floats around \n"
                + "throwing sparks flying everywhere in the crammed space\n"
                + "There is noting of real intrest here.\n"
                + "__________________________________________________________________\n"
                +"From this hallway oyu can go:\nWest\nEast";
    
    }
}
