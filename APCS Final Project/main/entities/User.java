package entities;

import java.awt.Point;

import gui.Images;
import gui.Room;
import main.Launcher;

public class User extends GameCharacter
{
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
        if (attacking )
        {
            attack();
        }
        if( moving )
        {
            if(dy < 0 && (getLocation().equals( new Point(8, 0) ) || getLocation().equals( new Point(9, 0) )))
            {
                Room nextRoom = Launcher.getGame().getLevel().generateRoom( new Room(15), 2 );
                setLocation(new Point(getLocation().x, nextRoom.getMap().getLayout()[0].length-1));
            }
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

    @Override
    protected void successKill(GameCharacter other)
    {
        addToScore(other.score);
    }

    @Override
    protected boolean isAgainst( Entity other )
    {
        return other instanceof Enemy;
    }
}
