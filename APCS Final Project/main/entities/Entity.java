package entities;

import gui.Room;

import java.awt.Point;
import javax.swing.ImageIcon;

public abstract class Entity extends Thread
{
    protected Point location;
    protected String type;
    protected ImageIcon image;
    protected ImageIcon current;
    protected Room room;
    
    public Entity(Room r, Point p)
    {
        r.add( p, this );
        room = r;
        location = p;
        type = null;
    }
    
    @Override
    public abstract void run();
    
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
