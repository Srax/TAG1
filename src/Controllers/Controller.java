package Controllers;

import Boundry.Boundry;
import Enteties.Player;
import highscore.HighscoreManager;
import java.util.Random;

public class Controller {

    Random rnd = new Random();
    Boundry b = new Boundry();
    CreateRoom cr = new CreateRoom();
    Player player = new Player();
    HighscoreManager hm = new HighscoreManager();
    PlayerActionController playerActionCtrl = new PlayerActionController();
    CombatController combatCtrl = new CombatController();

    /**
     * Manages game, movement form room, to next room, checks for winning room,
     * and checks for monsters.
     *
     * @throws java.lang.InterruptedException
     */
    public void game() throws InterruptedException {

        boolean checkVictory = true;

        cr.roomFeatures(); //Running the roomFeatures to generate the dungeon with rooms, items and monsters 
        cr.addPlayerStartItems(player); // adding starts items to the player
        b.welcomeToGame();
        b.createName(player); //Player choose name
        player.setLastRoom(cr.spaceShip); //Setting the players lastRoom. Used for the "run" method
        player.setCurrentRoom(cr.startRoom); //Setting the players starting room
        
        System.out.println(player.getCurrentRoom().toString());
        Thread.sleep(1000);
        
        //The game runs this loop for every room that the player enters.
        while (checkVictory) {
            Thread.sleep(500); 
            taxRobot(player); //First checks for taxRobots in the room
            trap(); //Second checks for traps in the room
            checkVictory = gameEndConditions(player); //Then checks the win/lose conditions
            
            //The game checks for monsters in the room, if the code detectss a monster, it runs the combat
            if (player.getCurrentRoom().getMonster() != null) {
                combatCtrl.combat(player); //Runs the combat
            } else if (player.getHp() <= 0) { //Checks if player is dead
                b.youDied();
                checkVictory = false; //If player is dead, game ends
            } else if (cr.gameSpaceCrawler != player.checkInventoryForWinItem("The game SPACE CRAWLER cause Space Invaders was already taken") && player.getCurrentRoom() != cr.spaceShip){
                //To win the game, the player needs to pick up the item above. this is checked here. 
                player.setLastRoom(player.getCurrentRoom());//The game changes the lastRoom virable
                playerActionCtrl.playerAction(player, cr); //The player takes an action.
            }
        }
        hm.addScore(player.getName(), player.getBank(), player.getHp()); //Prints virables to the highscore document 
        System.out.print(hm.getHighscoreString()); //Prints out the highscore for the player
    }
    /**
    * Runs a check for win conditions, and returns a boolean, 
    * to end the game() loop if found.
    * @param player
    * @return 
    */
    public boolean gameEndConditions(Player player) {
        boolean checkVictory = true;
        if (cr.gameSpaceCrawler == player.checkInventoryForWinItem("The game SPACE CRAWLER cause Space Invaders was already taken")){ //checks game win condition
            b.youWon(player);
            checkVictory = false;
        } else if (player.getCurrentRoom() == cr.spaceShip) { //Checks if player wish to quit the game
            b.youQuit(player);
            checkVictory = false;
        }
        return checkVictory;
    }

    /**
     * Interacts with the taxCollector. After a checking if there is a tax
     * collector in the room this method runs the possible outcomes of this
     * encounter based on player input.
     * @param player
     */
    public void taxRobot(Player player) {
        int taxRobot = player.getCurrentRoom().getTaxCollector();
        if (taxRobot > 0) { //Checks for taxRobt condition
            b.taxCollectorMeeting();
            boolean interaction = true;
            int dmg = rnd.nextInt(8)+8; //Generates a random amount that the player must pay the taxcollector
            while (interaction) {
                String choice = b.chooseAction();
                if (player.getBank() > 20) {

                    if (choice.equalsIgnoreCase("pay")) {
                        player.setBank(-20); //If the player pay the Taxcollector, lowers bank by 20
                        b.taxCollectorPay(player);
                        player.getCurrentRoom().setTaxCollector(0); //removes the taxcollector from the game
                        interaction = false;
                    } else if (choice.equalsIgnoreCase("deny")) {
                        player.getCurrentRoom().setGold(player.getBank()); //if the player denies the robot, it will take their gold and leave it in the room
                        player.setBank(-player.getBank()); //The player lose gold equal to rnd.nextInt
                        player.setHp(-dmg); //Player is given damage equal to the rnd.nextInt
                        
                        b.playSound(b.smashSound);
                        b.taxCollectorDeny(player);
                        player.getCurrentRoom().setTaxCollector(0); //Removes taxCollector form the game
                        interaction = false;
                    } else {
                        b.nothingHappend();
                    }

                } else if (choice.equalsIgnoreCase("help")) {
                    b.helpCommand(); //Display a list of command possible in the game
                } else if (choice.equalsIgnoreCase("pay") || choice.equalsIgnoreCase("deny") && player.getBank() < 20) { //If the player lacks the funds to pay the robot
                    player.getCurrentRoom().setGold(player.getBank()); //Player gold added to the room
                    player.setHp(-dmg); //Player takes damage equal to the rnd.nextInt
                    b.playSound(b.smashSound);
                    b.taxCollectorCantPay(player, dmg);
                    player.getCurrentRoom().setTaxCollector(0); //Removes taxrobot from room
                    interaction = false;
                } else {
                    b.nothingHappend();
                }
            }
        }
    }

    /**
     * Runs the trap encounter.
     */
    public void trap() {
        int trap = player.getCurrentRoom().getTrap();
        if (trap > 0) { //checks for trap condition
            b.trapInteraction();
            player.setHp(-(rnd.nextInt(3)+7)); //Player lose rnd.nextInt
            b.getHp(player);
            player.getCurrentRoom().setTrap(0); //removes trap form the game
        }

    }
    
  }
