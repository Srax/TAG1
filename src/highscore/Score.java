/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highscore;

/**
 *
 * @author thoma
 */

/**
 * This class create an arrayList (score) that contains the Name, Gold and Hp of the player.
 * We implement serializable to be able to sort the array so that the player with the higest score will always be #1 on the scoreboard and so on.
 */
import java.io.Serializable;

public class Score  implements Serializable {
    private int highscoreBank;
    private String highscoreName;
    private int highscoreHp;
    
    public int getHighscoreHp() {
        return highscoreHp;
    }

    public int getHighscoreBank() {
        return highscoreBank;
    }

    public String getHighscoreName() {
        return highscoreName;
    }

    public Score(String highscoreName, int highscoreGold, int highscoreHp) {
        this.highscoreBank = highscoreGold;
        this.highscoreName = highscoreName;
        this.highscoreHp = highscoreHp;
    }
}