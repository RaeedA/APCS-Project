package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile
{
    private boolean passable;
    private final JLabel myLabel;
    private final ImageIcon image;
    private String myType;
    
    public Tile(boolean pass, JLabel label, String type)
    {
        passable = pass;
        myLabel = label;
        image = (ImageIcon)label.getIcon();
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
        return image;
    }
    public String toString()
    {
        return getType();
    }
}
