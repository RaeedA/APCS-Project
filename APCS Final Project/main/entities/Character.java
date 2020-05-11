package entities;

import java.awt.Point;

import javax.swing.ImageIcon;

import gui.Images;
import gui.Room;

public abstract class Character extends Entity
{
    protected int health;
    protected int attackDamage;
    protected int iconNum;
    
    public Character(Room room, Point p)
    {
        super(room, p);
    }
    
    public int getHealth() {return health;}
    public void setHealth(int health) { this.health = health; }
    public void move(Point p)
    {
        room.move(this, p);
    }
    public void charSleep( int duration )
    {
        try
        {
            sleep( duration );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public abstract void run();
    public abstract void update();
}
