package App;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Boundry {
    
    Scanner scan = new Scanner(System.in); //used for actions
    Scanner scan2 = new Scanner(System.in); //Used in creatName
    public static String coinSound = System.getProperty("user.dir") + "\\src\\sounds\\coin.wav";
    public static String doorSound = System.getProperty("user.dir") + "\\src\\sounds\\doorShortLoud.wav";

    /**
     * Creates a player name
     *
     * @param p
     */
    public void createName(Player p) {

        boolean donePickingName = false;
        String inputName = null;
        String actionInput;

        while (donePickingName == false) {
            System.out.println("\nWHAT IS YOUR NAME?");
            System.out.print("NAME: ");
            inputName = scan2.next();

            if (inputName.length() <= 12) {
                System.out.println("You chose " + "'" + inputName + "'" + " as your name.\n");
                System.out.println("Hello " + inputName + "!");
                System.out.println("This will be your name through the whole game, do you want to keep it?\n"
                        + "YES/NO");
                System.out.print("ACTION: ");

                actionInput = scan2.next().substring(0, 1);

                if (actionInput.equalsIgnoreCase("n")) {
                    donePickingName = false;
                } else if (actionInput.equalsIgnoreCase("y")) {
                    System.out.println("\nYou chose to keep your name");
                    donePickingName = true;
                } else {
                    System.out.println("\n'" + actionInput + "'" + " is not a valid option... Try again.");
                }
            } else {
                System.out.println("\nSORRY BUT YOUR NAME IS TOO LONG!\nPlease keep your name at 12 or less characters.");
            }

        }
        p.setName(inputName);
    }

    /**
     * Welcoming to game statement. Introduce the games name and Rules.
     */
    public void welcomeToGame() {
        System.out.println("     _____                                    _____                             _               \n"
                + "    / ____|                                  / ____|                           | |              \n"
                + "   | (___    _ __     __ _    ___    ___    | |       _ __    __ _  __      __ | |   ___   _ __ \n"
                + "    \\___ \\  | '_ \\   / _` |  / __|  / _ \\   | |      | '__|  / _` | \\ \\ /\\ / / | |  / _ \\ | '__|\n"
                + "    ____) | | |_) | | (_| | | (__  |  __/   | |____  | |    | (_| |  \\ V  V /  | | |  __/ | |   \n"
                + "   |_____/  | .__/   \\__,_|  \\___|  \\___|    \\_____| |_|     \\__,_|   \\_/\\_/   |_|  \\___| |_|   \n"
                + "            | |  \t  BECAUSE SPACE INVADERS WERE ALREADY TAKEN                                                                               \n"
                + "            |_| \n\n");

        System.out.println("=== WELCOME ===\n");
        System.out.println("Welcome to Space Crawler!");
        System.out.println("Space Crawler is a text-based Dungeon-Crawler where the main objective of the game is to reach the command bridge.");
        System.out.println("You interact with the game by 'USER INPUT':\n - E.G: Write 'HELP' to recieve a list of commands.");
        System.out.println("\nThis game supports sounds, so turn up the volume.");

        System.out.println("\n=== GAME : RUNNING ===");
    }

    
    /**
     * This Method lets the player know that he/she can preform an action in
     * various situations
     *
     * @return
     */
    public String chooseAction() {
        System.out.print("Choose your action: ");
        String action = scan.nextLine();
        System.out.print("\n");
        return action;
    }

    /**
     * If the player is lost, helpCommadn will allow the player to enter "Help"
     * as an input and get a list of all possible actions in the game.
     */
    public void helpCommand() {
        System.out.println("\n============ HELP ===========");
        
        System.out.println("Unequip\tInventory\n"
                + "Search\tBank\tInspect\n"
                + "North\tSouth\tEast\tWest\n"
                + "Pay\tDeny\tUse\tHelp\n"
                + "Equip\tStats\tAttack\tExit\n"
                + "_____________________________\n");
        
        
//        
//        System.out.println("- Inspect\t- Search\t- Bank");
//
//        System.out.println("- North / South / East / West\n");
//        System.out.println("- Pay\t- Deny\t- Use");
//
//        System.out.println("- Equip\t- Unequip\t- Inventory ");        
//
//        System.out.println("- Stats\t- Attack\t- Help");
//
//        System.out.println("- Exit\n");
    }

    public void attackHelp() {
        System.out.println("\n=========== HELP ===========");
        System.out.println("- attack");
        System.out.println("- run");
        System.out.println("- inventory");
        System.out.println("- use");
        System.out.println("");

    }

    /**
     * When encountering the taxRobot, this method will display the following
     * for the player to react to.
     */
    public void taxCollectorMeeting() {

        System.out.println("===================================================================================\n");
        System.out.println("The door close behind you.");
        System.out.println("A big robot in a dark coat stands in your way");
        System.out.println("He is the \"TAXCOLLETOR\" and he is here to collect your money");
        System.out.println("You must pay his price to exit the room");
        System.out.println("You must pay me, 20 dollars\n");
        System.out.println("===================================================================================\n");
    }

    public void taxCollectorPay(Player player) {
        System.out.println("-20 Space dollars your Bank balance is now :" + player.getBank() + "$\n");
        System.out.println("You pay the robot and he looks satisfied");
        System.out.println("The Robot powers down while whispering finally. The robot should no longer be a problem\n");
    }

    public void taxCollectorDeny(Player player) {
        System.out.println("The Robot bitchslaps you, and steals all your money. you now have " + player.getHp() + "HP");
        System.out.println("The Robot powers down, and drops its money\nThe robot should no longer be a problem\n");
    }

    public void taxCollectorCantPay(Player player) {
        System.out.println("You were unable to pay the Robot");
        System.out.println("The Robot bitchslaps you, you now have " + player.getHp() + "HP");
        System.out.println("The Robot powers down, and drops its money\nThe robot should no longer be a problem\n");
    }

    void trapInteraction() {
        System.out.println("THERE SOUNDS A LOUD BANG!!!\n");
        System.out.println("Some of the ceiling collapses\n");
        System.out.println("You get hit by some rubble and lose 10 HP\n");
    }

    public void youFindGold(int gold) {
        System.out.println("In this room you find " + gold + " space dollars");
    }

    public void noGold() {
        System.out.println("There are no space dollars in here.");
    }

    void getHp(Player hp) {
        System.out.println("You now have: " + hp.getHp() + "HP");
    }

    void nothingHappend() {
        System.out.println("Nothing happend\n");
    }

    public void canGo() {
        System.out.println("From this room you can go : ");
    }

    void showBank(Player p) {
        System.out.print("Your current Bank balance is:");
        System.out.println(p.getBank() + "$");
    }

    void directionChoice(String action) {
        System.out.println("\nYou went " + action + "\n");
    }

    void walkIntoWall(Player p) {
        p.setHp(-1);
        System.out.println("You are trying to walk into a wall!\n -1HP\n");
    }

    void youQuit(Room currentRoom, Player p) {
        System.out.println(currentRoom.getDescription());
        System.out.println(p.toString());

    }

    void youWon(Room currentRoom, Player p) {
        System.out.println(currentRoom.getDescription());
        System.out.println(p.toString());
        System.out.println("*********************************");
        System.out.println("*                               *");
        System.out.println("*        You won !!!!!          *");
        System.out.println("*                               *");
        System.out.println("*********************************");
    }

    void chooseItemToPick() {
        System.out.println("Which item do you wish to pick up?");

    }
    void youPickedUp(){
        System.out.println("you picked up ");
    }

    void chooseItemToDrop() {
        System.out.println("Which item do you wish to drop?");
    }

    /**
     * The method reads a path to a .wav sound file, given by a string then
     * plays the sound when called
     *
     * @param s
     */
    public void playSound(String s) {
        try {
            File soundFile = new File(s);
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

            // load the sound into memory (a Clip)
            DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(sound);

            // due to bug in Java Sound, explicitly exit the VM when
            // the sound has stopped.
            clip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        event.getLine().close();
                    }
                }
            });

            // play the sound clip
            clip.start();
        } catch (IOException e) {
        } catch (LineUnavailableException e) {
        } catch (UnsupportedAudioFileException e) {
        }
    }

    void chooseItemToUse() {
        System.out.println("Witch item do you wish to use?\n");
    }

    void youDropped(String item) {
        System.out.println("\nYOU DROPPED: " + item + "\n");
    }

    void youUsed(String item) {
        System.out.println("\nYOU USED: " + item + "\n");
    }

    void youCannotUseItem() {
        System.out.println("You cannot use this item\n");
    }

    ///////////////////// COMBAT DISPLAY ////////////////////////
    
    public void monsterEncounter(String monsterName){
        System.out.println("===================================================================================\n");
        System.out.println("You float into the next room, but suddenly infront of you you see a monster!!!!!."
                + "\n"
                + "It is an enemy " + monsterName + " ready to fight you!"
                + "\n"               
                + "\n"               
                + "Before you can react, the " + monsterName + " attacks you!");

    }
    public void monsterAttacksYou(String monsterName,int damage, int hp){
        System.out.println("The "+monsterName+" attacks you and hits you"
                + " for " + damage + " damage.");
        System.out.println("You now have " + hp + " HP left\n");
        
            
    
    } 
    
    public void playerAttackMonster(String monsterName,int damage, int hp){
        System.out.println("You attack the "+ monsterName + " for " + damage + " damage.");
        System.out.println("The "+monsterName+" now has "+hp+"HP left\n");
    }
    
    public void monsterIsDead(String monsterName){
        System.out.println("The "+monsterName+"is hit one last time and stops moving.\n"
                + "Congratulation, you killed the " +monsterName+"!!");
        System.out.println("You can now explore the room.\n");
        System.out.println("===================================================================================\n");

    }

    public void monsterDroppedGold(String monsterName, int monsterGold) {
        System.out.println(monsterName + " dropped " + monsterGold + " space dollars.");
    }
    public void witchItemToEquip() {
        System.out.println("Witch item do you wish to equip?");
    }

    public void youCannotEquipItem() {
        System.out.println("You cannot equip this item");
    }

    public void witchItemToUnequip() {
        System.out.println("To unequip armor, type \"Armor\", for weapon type \"Weapon\"");
    }
    public void youDied(){
        System.out.println("\n\t\t===💀 YOU ARE DEAD 💀===\n" +
"You are dead, you dead body is now floating in the endless space\n" +
"\t\t  for eternity, dead\n" +
"\n💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀💀\n");
    }

    public void monsterDropped(String item) {
        System.out.println("The monster dropped " + item);
    }
}
