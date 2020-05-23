package entities;

import java.awt.Point;

import gui.Images;
import gui.Room;

public class User extends GameCharacter
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
        images = Images.getWarrior();
        attackImages = Images.getAttackWarrior();
        image = images[0];
        
        attacking = false;
        moving = false;
        attackDamage = 1000;
        health = 1000;
        room.addEntity( this );
    }
    
    public void update()
    {
        front = new Point(getLocation().x + dx, getLocation().y + dy);
        if (attacking)
        {
            Entity frontEnemy;
            switch(facing)
            {
                case up:
                    frontEnemy = room.getUpEntity( location );
                    break;
                case down:
                    frontEnemy = room.getDownEntity( location );
                    break;
                case right:
                    frontEnemy = room.getRightEntity( location );
                    break;
                case left:
                    frontEnemy = room.getLeftEntity( location );
                    break;
                default:
                    frontEnemy = null;
            }
            if(frontEnemy instanceof Enemy)
            {
                if (attack((GameCharacter)frontEnemy))
                {
                    System.out.println(score);
                    addToScore(( (Enemy)frontEnemy ).getScore());
                }
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
