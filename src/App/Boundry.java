package App;

import java.util.Scanner;

public class Boundry {
    
    
    Scanner scan = new Scanner(System.in);

/**
 * Takes the parameter currentRoom and return the direction as a String, if the direction is possible, else try again.
 * @param currentRoom
 * @return String choice
 */
    public String playerDirection(Room currentRoom) {

        boolean pickingDirection = true;
        String choice = "";

        while (pickingDirection) {
            System.out.print("Choose your direction: ");
            choice = scan.next().toLowerCase();
            if (choice.equalsIgnoreCase("north") && currentRoom.getNorth() != null) {
                System.out.println("\nYou went North");
                pickingDirection = false;
            } else if (choice.equalsIgnoreCase("south") && currentRoom.getSouth() != null) {
                System.out.println("\nYou went South");
                pickingDirection = false;
            } else if (choice.equalsIgnoreCase("east") && currentRoom.getEast() != null) {
                System.out.println("\nYou went East");
                pickingDirection = false;

            } else if (choice.equalsIgnoreCase("west") && currentRoom.getWest() != null) {
                System.out.println("\nYou went West");
                pickingDirection = false;

            } else {
                System.out.println("'"+choice+"'" + " is an invalid input.. Please pick a valid direction.\n");
                pickingDirection = true;

            }
            
        }
        return choice;
    }
/**
 * 
 * Creates a player name 
     * @return String with name
 */
    public String createName() {

        boolean donePickingName = false;
        String inputName ="";
        
        while (donePickingName == false) {
            System.out.println("\nWHAT IS YOUR NAME?");
            System.out.print("NAME: ");
            inputName = scan.next();
           
            System.out.println("You chose " + "'" + inputName + "'" + " as your name.\n");
            System.out.println("Hello " + inputName + "!");
            System.out.println("This will be your name through the whole game, do you want to keep it?\n"
                    + "YES/NO");
            System.out.print("ACTION: ");

            String actionInput;
            actionInput = scan.next().substring(0, 1);

            if (actionInput.equalsIgnoreCase("n")) {
                donePickingName = false;
            }
            if (actionInput.equalsIgnoreCase("y")) {
                System.out.println("\nYou chose to keep your name");
                donePickingName = true;
            } else {
                System.out.println("\n'" + actionInput + "'" + " is not a valid option... Try again.");
            }
            
        }
    return inputName;
    }
/**
 * Welcoming to game statement.
 */
    public void welcomeToGame() {
        System.out.println("     _____                                    _____                             _               \n" +
"    / ____|                                  / ____|                           | |              \n" +
"   | (___    _ __     __ _    ___    ___    | |       _ __    __ _  __      __ | |   ___   _ __ \n" +
"    \\___ \\  | '_ \\   / _` |  / __|  / _ \\   | |      | '__|  / _` | \\ \\ /\\ / / | |  / _ \\ | '__|\n" +
"    ____) | | |_) | | (_| | | (__  |  __/   | |____  | |    | (_| |  \\ V  V /  | | |  __/ | |   \n" +
"   |_____/  | .__/   \\__,_|  \\___|  \\___|    \\_____| |_|     \\__,_|   \\_/\\_/   |_|  \\___| |_|   \n" +
"            | |                                                                                 \n" +
"            |_| \n\n");
        System.out.println("=== WELCOME ===\n");
        System.out.println("Welcome to the game\n");
        System.out.println("Intro Blah blah blah");
        System.out.println("Intro Blah blah blah");
        System.out.println("Intro Blah blah blah");
        System.out.println("Intro Blah blah blah");
    }

    public String takeGold() {
        String choice = "";
        System.out.println("\nDo you wish to pick up the gold ?");
        System.out.println("YES/NO");
        choice = scan.next();
        return choice;
    }

    void chooseAction() {
        System.out.println("Choose your action: ");
        String action = scan.next().toLowerCase();
        switch(action){
            case "inspect"
            case ""
        }
                
        
    }
    public void helpCommand() {
        System.out.println("\n=== HELP ===");
        System.out.println("- Inspect");
        System.out.println("- Search");
        System.out.println("- Bank");
        System.out.println("- Help");
        System.out.println("- Exit");
        System.out.println("- North / South / East / West");
        System.out.println("- Yes / No");
    }
}
