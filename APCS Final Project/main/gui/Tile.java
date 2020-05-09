package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile
{
    private boolean passable;
    private final JLabel myLabel;
    private String myType;
    
    public Tile(boolean pass, JLabel label, String type)
    {
        passable = pass;
        myLabel = label;
        myType = type;
    }
    
    public boolean isPassable()
    {
        return passable;
    }
    public void setPassable(boolean p)
    {
        passable = p;
    }
    public JLabel getLabel()
    {
        return myLabel;
    }
    public String getType()
    {
        return myType;
    }
    public void setType(String s)
    {
        myType = s;
    }
    public ImageIcon getImage()
    {
        return (ImageIcon)myLabel.getIcon();
    }
    public String toString()
    {
        return getType();
    }
}
