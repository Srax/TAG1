
package App;

public class Room {

    private int gold;
    private String description;
    private Room north = null;
    private Room south = null;
    private Room west = null;
    private Room east = null;
    private int taxCollector;

    public Room(String Description) {
        this.description = Description;
    }
    
    
    public int getTaxCollector() {
        return taxCollector;
    }

    public void setTaxCollector(int TaxCollector) {
        this.taxCollector = TaxCollector;
    }

    public Room() {
    }

    public int getGold() {
        return gold;
    }

    public Room(int gold, String Description) {
        this.gold = gold;
        this.description = Description;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room North) {
        this.north = North;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room South) {
        this.south = South;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room West) {
        this.west = West;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room East) {
        this.east = East;
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
            System.out.println(" East");
    }
    @Override
    public String toString() {
        
            return description;
       
    }

}
