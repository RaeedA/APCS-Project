package entities;

import java.awt.Point;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gui.Images;
import gui.Room;

public class User extends Character
{
    private int score;
    private int dx = 0;
    private int dy = 0;
    public User( Room room, Point p )
    {
        super(room, p);
        type = "user";
        health = 100;
        image = Images.getWarrior()[0];
        room.addEntity( this );
    }
    
    public void run()
    {
        while(isAlive)
        {
            charSleep( 200 );
            if(health < 0)
            {
                isAlive = false;
                System.out.println("User is dead");
            }
            update();
            
        }
    }
    
    public void update()
    {
        front = new Point(getLocation().x + dx, getLocation().y + dy);
        move( front );
        if(isAttacking)
        {
            entityAtFront = room.getEntityAtPoint( front );
            if(entityAtFront instanceof Character)
            {
                charToAttack = (Character) entityAtFront;
            }
            if(charToAttack != null && charToAttack.getType().equals( "enemy" ) )
            {
                charToAttack.receiveAttack( (int) (attackDamage * Math.random()));
            }
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
    

    
    
}
