
package App;

public class Room {

    private int gold;
    private String Description;
    private Room North = null;
    private Room South = null;
    private Room West = null;
    private Room East = null;

    public Room() {
    }

    public int getGold() {
        return gold;
    }

    public Room(int gold, String Description) {
        this.gold = gold;
        this.Description = Description;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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
    public void availableDirections(){
        System.out.println("From this room you can go : ");
        if(getNorth() != null)
            System.out.println(" North");
        
        if(getSouth() != null)
            System.out.println(" South");
        
        if(getWest() != null)
            System.out.println(" West");
            
        if(getEast() != null)
            System.out.println(" West");
    }
    @Override
    public String toString() {
        
            return Description;
       
    }

}
