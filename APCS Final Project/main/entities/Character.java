package entities;

import java.awt.Point;

import javax.swing.ImageIcon;

import gui.Room;

public abstract class Character extends Entity
{
    protected int health;
    protected int attackDamage;
    protected boolean isAlive;
    protected int iconNum;
    protected Point front;
    protected ImageIcon[] images;
    
    public Character(Room room, Point p)
    {
        super(room, p);
        iconNum = (int)(Math.random() * 4) -1;
        isAlive = true;              
    }
    
    protected int getHealth()
    {
        return health;
    }
    
    protected void setHealth(int health)
    {
        this.health = health;
    }
    
    protected void move(Point p)
    {
        room.move(this, p);
    }
    
    protected void charSleep( int duration )
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

    protected boolean attack(Character c)
    {
        if( c.getLocation().distance( location ) > 1.5 )
        {
            return false;
        }
        c.setHealth( c.getHealth()-attackDamage );
        return c.health < 0;
    }

    protected void die()
    {
        room.kill(this);
    }
    
    protected void idle()
    {
        iconNum++;
        if( iconNum == 4)
        {
            iconNum = 0;
        }
        room.redraw( this, images[ iconNum ]);
    }
    
    @Override
    public void run()
    {
        while(isAlive)
        {
            charSleep( 200 );
            if(health < 0)
            {
                isAlive = false;
                System.out.println(getType() + " is dead");
            }
            update(); 
        }
        die();
    }
    
    public abstract void update();
}
