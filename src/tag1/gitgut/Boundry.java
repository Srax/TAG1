/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

import java.util.Scanner;

public class Boundry {
    
    
    Scanner scan = new Scanner(System.in);

//    //Direction Test
    public String playerDirection(Room currentRoom) {

        boolean pickingDirection = true;
        String choice = "";

        while (pickingDirection) {
            System.out.print("Choose your direction: ");
            choice = scan.next().toLowerCase();
            if (choice.equalsIgnoreCase("north") && currentRoom.getNorth() != null) {
                System.out.println("You went North");
                pickingDirection = false;
            } else if (choice.equalsIgnoreCase("south") && currentRoom.getSouth() != null) {
                System.out.println("You went South");
                pickingDirection = false;
            } else if (choice.equalsIgnoreCase("east") && currentRoom.getEast() != null) {
                System.out.println("You went East");
                pickingDirection = false;

            } else if (choice.equalsIgnoreCase("west") && currentRoom.getWest() != null) {
                System.out.println("You went West");
                pickingDirection = false;

            } else {
                System.out.println("'"+choice+"'" + " is an invalid input.. Please pick a valid direction.");
                pickingDirection = true;

            }
            
        }
        return choice;
    }

    public void createName() {

        boolean donePickingName = false;

        while (donePickingName == false) {
            System.out.println("\nWHAT IS YOUR NAME?");
            System.out.print("NAME: ");

            Scanner sc = new Scanner(System.in);

            String inputName;

            inputName = sc.next();
            Player p = new Player(inputName);

            System.out.println("You chose " + "'" + p.getName() + "'" + " as your name.\n");
            System.out.println("Hello " + p.getName() + "!");
            System.out.println("This will be your name through the whole game, do you want to keep it?\n"
                    + "YES/NO");
            System.out.print("ACTION: ");

            String input;
            input = sc.next().substring(0, 1);

            if (input.equalsIgnoreCase("n")) {
                donePickingName = false;
            }
            if (input.equalsIgnoreCase("y")) {
                System.out.println("You chose to keep your name");
                donePickingName = true;
            } else {
                System.out.println("\n'" + input + "'" + " is not a valid option... Try again.");
            }

        }

    }

    public void welcomeToGame() {
        System.out.println("=== WELCOME ===\n");
        System.out.println("Welcome to the game\n");
        System.out.println("Intro Blah blah blah");
        System.out.println("Intro Blah blah blah");
        System.out.println("Intro Blah blah blah");
        System.out.println("Intro Blah blah blah");
    }
}
