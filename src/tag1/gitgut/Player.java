/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag1.gitgut;

/**
 *
 * @author thoma
 */
public class Player {
        
    private String name;
    private int hp;
    private int bank;

    
    
    
    public Player(String name/*, int hp, int bank*/) {
        this.name = name;
        this.hp = hp;
        this.bank = bank;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    } 
}
