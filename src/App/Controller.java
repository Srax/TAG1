package App;

import highscore.HighscoreManager;
import java.util.Random;

public class Controller {

    CombatController combatController = new CombatController();
    Random rnd = new Random();
    Boundry b = new Boundry();
    CreateRoom cr = new CreateRoom();
    Player player = new Player();
    HighscoreManager hm = new HighscoreManager();
    PlayerActionController playerActionCtrl = new PlayerActionController();

//    Room currentRoom;
//    Room tempRoom = currentRoom;
    /**
     * Manages game, movement form room, to next room, checks for winning room,
     * collection of gold.
     *
     * @throws java.lang.InterruptedException
     */
    public void game() throws InterruptedException {

        boolean checkVictory = true;

        cr.roomFeatures();
        cr.addPlayerStartItems(player);
        b.welcomeToGame();

        //b.createName(player);
        player.setCurrentRoom(cr.startRoom);
        System.out.println(player.getCurrentRoom().toString());
        Thread.sleep(500);

        while (checkVictory) {
            Thread.sleep(500);
            taxRobot();
            trap();
            
            if (player.getCurrentRoom().equals(cr.finish)) {
                b.youWon(player.getCurrentRoom(), player);
                hm.addScore(player.getName(), player.getBank(), player.getHp());
                checkVictory = false;
            } else if (player.getCurrentRoom().equals(cr.spaceShip)) {
                b.youQuit(player.getCurrentRoom(), player);
                hm.addScore(player.getName(), player.getBank(), player.getHp());
                checkVictory = false;
            } else {
                b.playSound(b.doorSound);
                player.setLastRoom(player.getCurrentRoom());
                playerActionCtrl.playerAction(player);
                //combatController.combat(player.getCurrentRoom(), player);

            }
        }
        //Prints highscore
        System.out.print(hm.getHighscoreString());
    }

    /**
     * Interacts with the taxCollector. After a checking if there is a tax
     * collector in the room this method runs the possible outcomes of this
     * encounter based on player input.
     */
    public void taxRobot() {
        int taxRobot = player.getCurrentRoom().getTaxCollector();
        if (taxRobot > 0) {
            b.taxCollectorMeeting();
            boolean interaction = true;

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
                        player.setHp(-20);
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

                    player.setHp(-20);
                    b.taxCollectorCantPay(player);
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
            player.setHp(-10);
            b.getHp(player);
            player.getCurrentRoom().setTrap(0);
        }

    }



}
