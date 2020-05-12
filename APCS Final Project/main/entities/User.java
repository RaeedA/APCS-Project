package entities;

import java.awt.Point;

import gui.Images;
import gui.Room;

public class User extends Character
{
    private int score;
    private int dx = 0;
    private int dy = 0;
    private boolean attacking;
    private boolean moving;
    
    public User( Room room, Point p )
    {
        super(room, p);
        type = "user";
        attacking = false;
        moving = false;
        images = Images.getWarrior();
        image = images[0];
        attackDamage = 1000;
        health = 100;
        room.addEntity( this );
    }
    
    public void update()
    {
        front = new Point(getLocation().x + dx, getLocation().y + dy);
        if (attacking)
        {
            Entity surrounding = room.getAdjacent( location );
            if(surrounding instanceof Enemy)
            {
                attack((Character)surrounding);
            }
        }
        if(moving)
        {
            move( front );
        }
        else
        {
            idle();
        }
    }
    
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore( int score )
    {
        this.score = score;
    }
    
    public void addToScore(int points)
    {
        score += points;
    }
    
    public void setDx( int dx )
    {
        this.dx = dx;
    }
    
    public void setDy( int dy )
    {
        this.dy = dy;
    }
    public void setAttacking(boolean a)
    {
        attacking = a;
    }
    public boolean isAttacking()
    {
        return attacking;
    }
    public void setMoving(boolean m)
    {
        moving = m;
    }
    public boolean isMoving()
    {
        return moving;
    }
}
