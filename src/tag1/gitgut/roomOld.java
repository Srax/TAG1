/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

import java.util.Scanner;

/**
 *
 * @author thoma
 */
public class roomOld {
    private Scanner sc = new Scanner(System.in);
    boolean containsCoin = true;
    int bank;
    

    //MAIN ROOM
    public void room1() {
        String input = "";
        
        
        System.out.println("\n== DUNGEON ENTRANCE ==");
        System.out.println("You have entered the dungeon");
        System.out.println("This room has two doors:"
                + "\nN = Next Room"
                + "\nS = EXIT DUNGEON");

        
        System.out.print("CHOISE: ");
        input = sc.next();

        if (input.equalsIgnoreCase("N")) {
            room2();
        } else if (input.equalsIgnoreCase("S")) {
            System.out.println("You exited the dungeon...");
        } else {
            System.out.println("WRONG INPUT");
        }
        
    }

    //LIVING ROOM
    public void room2() {
        String input = "";

        System.out.println("\n== LIVING ROOM ==");
        System.out.println("You entered the Living Room");
        if (containsCoin == true) {
            System.out.println("There is a gold coin on the floor... pick it up?"
                    + "\n Y = Pick up the coin"
                    + "\n N = Leave it be");
            System.out.print("CHOISE: ");
            input = sc.next();

            if (input.equalsIgnoreCase("Y")) {
                bank = bank + 1; //Add a coin to the bank...
                containsCoin = false;                
                
                System.out.println("You picked up the coin...");
                System.out.println("You have a total of :" + bank + " coin(s)\n");
                
                System.out.println("This room has three doors:"
                        + "\nE = GO EAST"
                        + "\nW = GO WEST"
                        + "\nS = GO BACK");

                
                System.out.print("CHOISE: ");
                input = sc.next();
                
                if (input.equalsIgnoreCase("E")) {
                    room3();
                }
                if (input.equalsIgnoreCase("W")) {
                    room4();
                } else if (input.equalsIgnoreCase("S")) {
                    room1();
                }

            } else if (input.equalsIgnoreCase("N")) {
                System.out.println("You chose not to pick up the coin....\n");
                System.out.println("This room has three doors:"
                        + "\nE = GO EAST"
                        + "\nW = GO WEST"
                        + "\nS = GO BACK");

                
                System.out.print("CHOISE: ");
                input = sc.next();
                
                if (input.equalsIgnoreCase("E")) {
                    room3();
                }
                if (input.equalsIgnoreCase("W")) {
                    room4();
                } else if (input.equalsIgnoreCase("S")) {
                    room1();
                }
            }

        }

        if (containsCoin == false) {
            System.out.println("This room has three doors:"
                    + "\nE = GO BACK"
                    + "\nW = GO WEST"
                    + "\nS = GO BACK");

            
            System.out.print("CHOISE: ");
            input = sc.next();
            
            if (input.equalsIgnoreCase("E")) {
                room3();
            }
            if (input.equalsIgnoreCase("W")) {
                room4();
            } else if (input.equals("S")) {
                room1();
            }
        }
    }

    //CLOSET
    public void room3() {
        String input = "";
        
        System.out.println("== KITCHEN ==");
    }

    //KITCHEN
    public void room4() {
        String input = "";
        
        System.out.println("== CLOSET ==");
    }
}
