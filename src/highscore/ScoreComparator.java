
package highscore;


import java.util.Comparator;
/**
 * This class compare two score objects. 
 * -1 means the first score is greater than the 2nd one.
 * +1 means it's smaller.
 * 0 means it's equal.
 * E.G. If i score 200 and 300  =  200 will be +1 and 300 will be -1.
 * E.G. If i score 200 and 200  =  They will both be 0 because they are equal.
 */
public class ScoreComparator implements Comparator<Score> {
        public int compare(Score score1, Score score2) {

            int sc1 = score1.getHighscoreBank();
            int sc2 = score2.getHighscoreBank();

            if (sc1 > sc2){
                return -1;
            }else if (sc1 < sc2){
                return +1;
            }else{
                return 0;
            }
        }
}