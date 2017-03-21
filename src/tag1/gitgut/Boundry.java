/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

import java.util.Scanner;

public class Boundry {

    Room room = new Room();
    Scanner scan = new Scanner(System.in);

//    //Direction Test
    public String playerDirection() {

        boolean donePickDirection = true;
        System.out.println("Choose your direction");
        String choice = scan.next().substring(0, 1);
        while (donePickDirection) {
            if (choice.equalsIgnoreCase("N") && room.getNorth() != null) {
                System.out.println("You went North");
                donePickDirection = false;
            }

            else if (choice.equalsIgnoreCase("S") && room.getSouth() != null) {
                System.out.println("You went South");
                donePickDirection = false;
            }
            else if (choice.equalsIgnoreCase("E") && room.getEast() != null) {
                System.out.println("You went East");
                donePickDirection = false;
                
            }
            else if (choice.equalsIgnoreCase("W") && room.getWest() != null) {
                System.out.println("You went West");
                donePickDirection = false;
                
            } else {
                System.out.println("You can't go that way, try another way.");
                donePickDirection = true;
                
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
