
package highscore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * HighscoreManager.java class manages the highscore.
 */
public class HighscoreManager {
    
    /**
     * An arraylist containing 'Score'.
     */
    private ArrayList<Score> scores;

    /**
     * This is the file where the highscores will be saved
     * We chose to use .dat to make it harder to cheat the highscore.
     */
    private static final String HIGHSCORE_FILE = "highscores.dat";

    
    /**
     * Initialising an in and outputStream for working with the file
     */
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager() {
        /**
         * define the scores-arraylist
         */
        scores = new ArrayList<Score>();
    }
    
     /**
     * This function will return an arraylist with the scores in it.
     * It contains calls to the function loadScoreFile() and sort(),
     * these functions will make sure you have the scores from your high-score file in a sorted order.
     * E.G. The player with the higest score will always be #1 and so on.
     */
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
     /**
     * This function will create a new object "comparator" from the class ScoreComparator.
     * Collections.sort() function is in the Java Collections Class (a part of java.util). 
     * It allows you to sorlass ScoreComparator.
     * Collections.sort() function is in the Java Collections Class (a part of java.util).t the arraylist "scores" with help of "comparator".
     */
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }
    
    
    /**
     * addScore() is a method to add the players score to the highscore.dat file.
     * Parameters 'highscoreName', 'highscoreBank' and 'highscoreHp' are given.
     * These are the players name, bank and hp at the end of the game.
     
     * First the scores that are allready in the highscore.dat file are loaded into the 'scores'-arraylist.
     * Then the new scores are added to the arraylist and the high-score file is updated with it. 
     */
    public void addScore(String highscoreName, int highscoreBank, int highscoreHp) {
        loadScoreFile();
        scores.add(new Score(highscoreName, highscoreBank, highscoreHp));
        updateScoreFile();
    }

    
    /**
     * loadScoreFile() will load the arraylist from the highscore.dat file and will put it in the 'scores'-arraylist.
     * The 'The try-catch structure' will make sure the game won't crash if the highscore.dat file gets corupted or removed.
     */
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("\n[NOTE] FNF Error: " + e.getMessage());
            System.out.println("Created File highscores.dat");
        } catch (IOException e) {
            System.out.println("\n[NOTE] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("\n[NOTE] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }
    
    
    /**
     * updateScoreFile() write the 'score'-arraylist to the file.
     */
    
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    
    /**
     * getHighscoreString() define the way the highscore.dat file should be displayed.
     * We have made the file so that only the top 10 players will be displayed.
     * This can be raised or lowered by changing the value of int maxDisplayedPlayers;
     */
    public String getHighscoreString() {
        
        
        String highscoreString = "\n=== HIGHSCORES ===\n\n"
                + "No\tPLAYER\t\tBANK\t\tHP\n"
                + "---------------------------------------------\n";
        
	int maxDisplayedPlayers = 10; //The maximum number of players displayed in the highscore.dat file.

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > maxDisplayedPlayers) {
            x = maxDisplayedPlayers;
        }
        while (i < x) {
            //If the players name is shorter than 8 characters, add an extra 'tab' at the end of the name.
            //We added this function so that the score will be displayed with the same 'space' between Name, Bank and Hp as long as your name is between 1-12 characters.
            if (scores.get(i).getHighscoreName().length()<8) { //If the length of the name is less than 8 characters, add an extra \t after the name is displayed.
                highscoreString += (i + 1) + ".\t" + COLOR_BLUE + scores.get(i).getHighscoreName() + COLOR_RESET + "\t\t" + COLOR_GREEN + scores.get(i).getHighscoreBank() + COLOR_RESET + "$\t\t" + COLOR_RED + scores.get(i).getHighscoreHp()+ COLOR_RESET + "HP\t\t" + "\n";
            } else {
                highscoreString += (i + 1) + ".\t" + COLOR_BLUE + scores.get(i).getHighscoreName() + COLOR_RESET + "\t" + COLOR_GREEN + scores.get(i).getHighscoreBank() + COLOR_RESET + "$\t\t" + COLOR_RED + scores.get(i).getHighscoreHp()+ COLOR_RESET + "HP\t\t" + "\n";
            }
            i++; // adds +1 to i
        }
        return highscoreString;
    }
    
    /* COLORS */
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";
}
