/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author thoma
 */
import java.io.Serializable;

public class Score  implements Serializable {
    private int score;
    private String naam;
    private int hp;
    
    public int getHp() {
        return hp;
    }

    public int getScore() {
        return score;
    }

    public String getNaam() {
        return naam;
    }

    public Score(String naam, int score, int hp) {
        this.score = score;
        this.naam = naam;
        this.hp = hp;
    }
}