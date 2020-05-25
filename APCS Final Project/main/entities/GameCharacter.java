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
    protected int score;
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

    protected void attack()
    {
        Entity frontEnemy;
        int offx = 0;
        int offy = 0;
        switch(facing)
        {
            case up:
                frontEnemy = room.getUpEntity( location );
                offy = 10;
                break;
            case down:
                frontEnemy = room.getDownEntity( location );
                offy = -10;
                break;
            case right:
                frontEnemy = room.getRightEntity( location );
                offx = 10;
                break;
            case left:
                frontEnemy = room.getLeftEntity( location );
                offx = -10;
                break;
            default:
                frontEnemy = null;
        }
        if(isAgainst(frontEnemy))
        {
            GameCharacter enemy = (GameCharacter) frontEnemy;
            iconNum++;
            if( iconNum == 4)
            {
                iconNum = 0;
            }
            room.redraw( this, images[iconNum], offx, offy);
            enemy.setHealth( enemy.getHealth() - attackDamage );
            if (enemy.health < 0)
            {
                successKill(enemy);
            }
        }
    }
    
    protected abstract boolean isAgainst(Entity other);
    protected abstract void successKill(GameCharacter other);

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
            if(health <= 0)
            {
                isAlive = false;
                System.out.println(getType() + " is dead ");
            }
            update(); 
        }
        die();
    }
    
    protected abstract void update();
}
