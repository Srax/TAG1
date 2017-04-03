
package App;

import MonsterTypes.CorruptedWiers;
import MonsterTypes.Monster;

public class App {

    public static void main(String[] args) throws InterruptedException {
        
        Monster mCW = new CorruptedWiers("Corrupted Wiers", 30, 5, 20, 1);
        System.out.println(mCW);
        
               
        Controller c = new Controller();
        c.game();        
    }
}
