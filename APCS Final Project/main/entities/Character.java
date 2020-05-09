package entities;

import java.awt.Point;

import gui.Room;

public class Character extends Entity
{
    protected int health;
    protected int attackDamage;
    
    public Character()
    {
        
    }
    
    public Character(Room room, Point p)
    {
        super(room, p, "character");
    }
    
    public int getHealth() {return health;}
    public void setHealth(int health) { this.health = health; }
    public void moveTo(Point p)
    {
        //TODO: animation and process
        setLocation(p);
    }
}
