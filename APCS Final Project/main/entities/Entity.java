package entities;

import gui.Room;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Entity
{
    protected Point location;
    protected String type;
    protected ImageIcon image;
    protected ImageIcon current;
    
    public Entity()
    {
        //TODO: Default Constructor
    }
    
    public Entity(Room room, Point p, String t)
    {
        room.add( p, this );
        location = p;
        type = t;
    }
    
    public Point getLocation()
    {
        return location;
    }
    public void setLocation(Point p)
    {
        location = p;
    }
    public String getType()
    {
        return type;
    }
    public ImageIcon getImg()
    {
        return image;
    }
    public void setCurrent(ImageIcon icon)
    {
        current = icon;
    }
    public ImageIcon getCurrent()
    {
        return current;
    }
    
    //TODO: More methods
}
