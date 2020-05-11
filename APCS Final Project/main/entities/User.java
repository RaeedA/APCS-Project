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
        image = Images.getWarrior()[0];
        room.addEntity( this );
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                sleep( 200 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            update();
        }
    }
    
    public void update()
    {
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

    
    
}
