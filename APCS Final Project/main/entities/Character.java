package entities;

import java.awt.Point;
import gui.Images;
import gui.Room;

public class Character extends Entity
{
    
    public Character(Room room, Point p)
    {
        super(room, p, "character", new Images().getBottom()[0]);
    }
    
    public int getHealth() {return health;}
    public void setHealth(int health) { this.health = health; }
    public void move(Point p)
    {
        room.move(this, p);
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        
    }
}
