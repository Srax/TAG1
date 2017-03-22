
package App;

/**
 *
 * @author DD
 */
public class Description {



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

    //hallWay1 bruges på rum 1 og 2
    public String hallWay1() {
        String desc = "\n=== HALLWAY ===\n"
                + "You enter a dark and silent hallway, broken wiers floats around \n"
                + "throwing sparks flying everywhere in the crammed space\n"
                + "There is noting of real intrest here.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }

    //Bruges på rum 3
    public String hallWay2() {
        String desc = "\n=== HALLWAY ===\n"
                + "Still a hallway.\n"
                + "__________________________________________________________________\n";
                
        return desc;
    }

    public String closet() {

        String desc = "\n=== CLOSET ==\n"
                + "You entered an old dirty closet...\n"
                + "The closet contains an wooden broom, a rusty bucket and some old rags.\n"
                + "There appears to be nothing of value in here, go back.\n"
                +"__________________________________________________________________\n";
                
        return desc;
    }
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

    public String spaceShip() {
        String desc = "\n=== Space Ship ===\n"
                + "You have returned to your spaceship.\n";
                
        return desc;        
    }
    
}
