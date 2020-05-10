package entities;

import java.awt.Point;

import javax.swing.ImageIcon;

import gui.Images;
import gui.Room;

public class User extends Character
{
    private int score;
    public User( Room room, Point p )
    {
        super(room, p);
        type = "user";
        image = Images.getWarrior()[0];
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
