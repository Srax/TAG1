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
public class KeyItem implements Iitem{
    String name, description;
    boolean usable = false;
    
    KeyItem() {
       
    }    

    public KeyItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "Misc item >" + "\""+name+"\"" + " Description: \""+getDescription()+"\"";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean getUsable() {
        return this.usable;
    }

    @Override
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

}
