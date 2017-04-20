package items;

import Enteties.Player;

/**
 *
 * @author Stanislav
 */
public interface Iitem {
    
    public String getName();
    public String getDescription();
    @Override
    public String toString();
    public boolean getUsable();
    public void setUsable(boolean usable);
    public void use(Player player);
    public boolean equipable();
    public void equip(Player player);

    
}
