package Controllers;

import Boundry.Boundry;
import Enteties.Player;
import Controllers.CreateRoom;
import Controllers.CombatController;
import Controllers.PlayerActionController;
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

        cr.roomFeatures();
        cr.addPlayerStartItems(player);
        b.welcomeToGame();
        b.createName(player);
        player.setLastRoom(cr.spaceShip);
        player.setCurrentRoom(cr.startRoom);
        
        System.out.println(player.getCurrentRoom().toString());
        Thread.sleep(1000);
        
        while (checkVictory) {
            Thread.sleep(500);
            taxRobot(player);
            trap();
            checkVictory = gameEndConditions(player);
            
            if (player.getCurrentRoom().getMonster() != null) {
                combatCtrl.combat(player);
            } else if (player.getHp() <= 0) {
                b.youDied();
                checkVictory = false;
            } else if (cr.gameSpaceCrawler != player.checkInventoryForWinItem("The game SPACE CRAWLER cause Space Invaders was already taken") && player.getCurrentRoom() != cr.spaceShip){
                player.setLastRoom(player.getCurrentRoom());
                playerActionCtrl.playerAction(player, cr);
            }
        }
        hm.addScore(player.getName(), player.getBank(), player.getHp());
        System.out.print(hm.getHighscoreString());
    }
    /**
    * Runs a check for win conditions, and returns a boolean, 
    * to end the game() loop if found.
    * @param player
    * @return 
    */
    public boolean gameEndConditions(Player player) {
        boolean checkVictory = true;
        if (cr.gameSpaceCrawler == player.checkInventoryForWinItem("The game SPACE CRAWLER cause Space Invaders was already taken")){
            b.youWon(player);
            checkVictory = false;
        } else if (player.getCurrentRoom() == cr.spaceShip) {
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
        if (taxRobot > 0) {
            b.taxCollectorMeeting();
            boolean interaction = true;
            int dmg = rnd.nextInt(8)+8;
            while (interaction) {
                String choice = b.chooseAction();
                if (player.getBank() > 20) {

                    if (choice.equalsIgnoreCase("pay")) {
                        player.setBank(-20);
                        b.taxCollectorPay(player);
                        player.getCurrentRoom().setTaxCollector(0);
                        interaction = false;
                    } else if (choice.equalsIgnoreCase("deny")) {
                        player.getCurrentRoom().setGold(player.getBank());
                        player.setBank(-player.getBank());
                        
                        player.setHp(-dmg);
                        b.playSound(b.smashSound);
                        b.taxCollectorDeny(player);
                        player.getCurrentRoom().setTaxCollector(0);
                        interaction = false;
                    } else {
                        b.nothingHappend();
                    }

                } else if (choice.equalsIgnoreCase("help")) {
                    b.helpCommand();
                } else if (choice.equalsIgnoreCase("pay") || choice.equalsIgnoreCase("deny") && player.getBank() < 20) {
                    player.getCurrentRoom().setGold(player.getBank());
                    player.setHp(-dmg);
                    b.playSound(b.smashSound);
                    b.taxCollectorCantPay(player, dmg);
                    player.getCurrentRoom().setTaxCollector(0);
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
        if (trap > 0) {
            b.trapInteraction();
            player.setHp(-(rnd.nextInt(3)+7));
            b.getHp(player);
            player.getCurrentRoom().setTrap(0);
        }

    }
    
  }
