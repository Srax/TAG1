package items;

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
    
    
}
