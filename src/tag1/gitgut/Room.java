/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;



public class Room {
    private int gold;
    private String Discription;
    private String North;
    private String South;
    private String West;
    private String East;

    public int getGold() {
        return gold;
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

    public String getNorth() {
        return North;
    }

    public void setNorth(String North) {
        this.North = North;
    }

    public String getSouth() {
        return South;
    }

    public void setSouth(String South) {
        this.South = South;
    }

    public String getWest() {
        return West;
    }

    public void setWest(String West) {
        this.West = West;
    }

    public String getEast() {
        return East;
    }

    public void setEast(String East) {
        this.East = East;
    }

    public Room(int gold, String Discription, String North, String South, String West, String East) {
        this.gold = gold;
        this.Discription = Discription;
        this.North = North;
        this.South = South;
        this.West = West;
        this.East = East;
    }
    
}
