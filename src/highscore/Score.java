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
import java.io.Serializable;

public class Score  implements Serializable {
    private int highscoreGold;
    private String highscoreName;
    private int highscoreHp;
    
    public int getHp() {
        return highscoreHp;
    }

    public int getScore() {
        return highscoreGold;
    }

    public String getNaam() {
        return highscoreName;
    }

    public Score(String naam, int score, int hp) {
        this.highscoreGold = score;
        this.highscoreName = naam;
        this.highscoreHp = hp;
    }
}