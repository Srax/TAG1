/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

import java.util.Scanner;

public class Boundry {
    Scanner scan = new Scanner(System.in);
    
    //Direction Test
    public String playerDirection(){
        System.out.println("Choose your direction");
        String choice = scan.next().toLowerCase();
        return choice;
    }
    
    public void createName() {
    
        boolean donePickingName = false;
        
        while (donePickingName == false ) {
            System.out.println("\nWHAT IS YOUR NAME?");
            System.out.print("NAME: ");
            
            Scanner sc = new Scanner(System.in);
            
            String inputName;         
            
            inputName = sc.next();      
            Player p = new Player(inputName);
        
            
            System.out.println("You chose " + "'" + p.getName() + "'" +" as your name.\n");
            System.out.println("Hello " + p.getName() + "!");
            System.out.println("This will be your name through the whole game, do you want to keep it?\n"
                    + "YES/NO");
            System.out.print("ACTION: ");
            
            String input;
            input = sc.next().substring(0,1);
            
            if (input.equalsIgnoreCase("n")){                
                donePickingName = false;
            }
            else if (input.equalsIgnoreCase("y")) {
                System.out.println("You chose to keep your name");
                donePickingName = true;
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
