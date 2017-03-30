/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author thoma
 */
public class HighscoreManager {
    
    // An arraylist of the type "score" we will use to work with the scores inside the class
    private ArrayList<Score> scores;

    // The name of the file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "scores.dat";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager() {
        //initialising the scores-arraylist
        scores = new ArrayList<Score>();
    }
    
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }
    
    public void addScore(String name, int score, int hp) {
        loadScoreFile();
        scores.add(new Score(name, score, hp));
        updateScoreFile();
    }
    
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            //System.out.println("[BOI] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            //System.out.println("[BOI] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            //System.out.println("[BOI] CNF Error: " + e.getMessage());
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
    
    public String getHighscoreString() {
        String highscoreString = "\n=== HIGHSCORES ===\n\n"
                + "No\tPLAYER\t\tBANK\t\tHP\n";
        
	int max = 10; //The maximum number of scores displayed

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            if (scores.get(i).getNaam().length()<8) { //If the length of the name is less than 8 characters, add an extra \t after the name is displayed.
                highscoreString += (i + 1) + ".\t" + scores.get(i).getNaam() + "\t\t" + scores.get(i).getScore() + "$\t\t" + scores.get(i).getHp() + "HP\n";
            } else {
                highscoreString += (i + 1) + ".\t" + scores.get(i).getNaam() + "\t" + scores.get(i).getScore() + "$\t\t" + scores.get(i).getHp() + "HP\n";
            }
            i++; // adds +1 to i
        }
        return highscoreString;
    }
}
