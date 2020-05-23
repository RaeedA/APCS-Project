package entities;

import java.awt.Point;

import javax.swing.ImageIcon;

import gui.Room;

public abstract class GameCharacter extends Entity
{
    protected int health;
    protected int attackDamage;
    protected boolean isAlive;
    protected int iconNum;
    protected Point front;
    protected ImageIcon[] images;
    protected ImageIcon[] attackImages;
    protected enum Directions{up, down, left, right};
    protected Directions facing;
    
    public GameCharacter(Room room, Point p)
    {
        super(room, p);
        iconNum = (int)(Math.random() * 4) -1;
        isAlive = true;              
    }
    
    protected int getHealth()
    {
        return health;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    protected void move(Point p)
    {
        room.move(this, p);
        idle();
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

    protected boolean attack(GameCharacter frontEnemy)
    {
        Point other = frontEnemy.getLocation();
        if( other.distance( location ) > 1.5 )
        {
            return false;
        }
        iconNum++;
        if( iconNum == 4)
        {
            iconNum = 0;
        }
        int offx = 0;
        int offy = 0;
        if (facing == Directions.right)
        {
            offx = 1;
        }
        else if (facing == Directions.left)
        {
            offx = -1;
        }
        else if (facing == Directions.up)
        {
            offy = 1;
        }
        else if (facing == Directions.down)
        {
            offy = -1;
        }
        else
        {
            return false;
        }
        room.redraw( this, attackImages[iconNum] , offx, offy);
        frontEnemy.setHealth( frontEnemy.getHealth()-attackDamage );
        return frontEnemy.health < 0;
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
    
    public void faceUp()
    {
        facing = Directions.up;
    }
    
    public void faceDown()
    {
        facing = Directions.down;
    }
    
    public void faceRight()
    {
        facing = Directions.right;
    }
    
    public void faceLeft()
    {
        facing = Directions.left;
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
                System.out.println(getType() + " is dead ");
            }
            update(); 
        }
        die();
    }
    
    public abstract void update();
}
