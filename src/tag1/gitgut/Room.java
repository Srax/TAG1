
package tag1.gitgut;

public class Room {

    private int gold;
    private String Discription;
    private Room North = null;
    private Room South = null;
    private Room West = null;
    private Room East = null;

    public Room() {
    }

    
    
    
    public int getGold() {
        return gold;
    }

    public Room(int gold, String Discription) {
        this.gold = gold;
        this.Discription = Discription;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }

    public Room getNorth() {
        return North;
    }

    public void setNorth(Room North) {
        this.North = North;
    }

    public Room getSouth() {
        return South;
    }

    public void setSouth(Room South) {
        this.South = South;
    }

    public Room getWest() {
        return West;
    }

    public void setWest(Room West) {
        this.West = West;
    }

    public Room getEast() {
        return East;
    }

    public void setEast(Room East) {
        this.East = East;
    }

    @Override
    public String toString() {
       
            return Discription + "\n\nIn the Room you find " + gold + " Space Dollars";
       
    }
//    public Room Direction(String choice){
//        if(choice.equals("north"))
//            return getNorth();
//        if(choice.equals("south"))
//            return getSouth();
//        if(choice.equals("east"))
//            return getEast();
//        if(choice.equals("west"))
//            return getWest();
//        
//        return null;
//    }
}
