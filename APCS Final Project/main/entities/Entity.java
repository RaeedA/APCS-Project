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
    protected int health;
    protected int attackDamage;
    protected Room room;
    
    public Entity(Room r, Point p, String t, ImageIcon img)
    {
        r.add( p, this );
        room = r;
        image = img;
        location = p;
        type = t;
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
