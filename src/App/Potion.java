/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author jonas
 */
public class Potion implements Iitem{
    String name, description;
    private int hpRestore;
    
    Potion() {
       
    }    

    public Potion(String name, String description, int hpRestore) {
        this.name = name;
        this.description = description;
        this.hpRestore = hpRestore;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public int getAttackDMG() {
        return hpRestore;
    }

    public void setAttackDMG(int defense) {
        this.hpRestore = defense;
    }

    @Override
    public String toString() {
        return "Weapon " + " name: " + name + " HP restore amount: "+hpRestore + " Description: "+getDescription();
    }

    @Override
    public String getDescription() {
        return description;
    }

}