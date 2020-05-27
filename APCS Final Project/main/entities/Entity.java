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
    
    /**
     * @param r
     * @param p
     */
    public Entity(Room r, Point p)
    {
        room = r;
        location = p;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
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
    
    public Room getRoom()
    {
        return room;
    }
    
    public void setRoom( Room room )
    {
        this.room = room;
        setLocation( new Point(getLocation().x, 0 ));
    }
    protected void move(Point p)
    {
        room.move( this, p );
    }
    
}
