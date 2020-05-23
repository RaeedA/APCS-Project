package entities;

import java.awt.Point;

import gui.Images;
import gui.Room;

public class Enemy extends GameCharacter
{
    private int randDecision;
    private int difficulty;
    private int score;
    public Enemy(Room room, Point p)
    {
        super(room, p);
        type = "enemy";
        health = 100;
        difficulty = 30;
        
        images = Images.getSkeleton();
        image = images[0];
        score = 0;
        randDecision = (int) (Math.random() * 100);
        room.addEntity( this );
    }
    
    public void update()
    {
        if (randDecision < difficulty)
        {
            moveToPlayer();
        }
        else
        {
            idle();
        }
        randDecision = (int) (Math.random() * 100);
    }
    
    public int getScore()
    {
        return score;
    }
    public void moveToPlayer()
    {
        Point userLocation = room.getUser().getLocation();
        int myX = getLocation().x;
        int myY = getLocation().y;
        int userX = userLocation.x;
        int userY = userLocation.y;
        if(Math.abs( myX  - userX) > Math.abs( myY - userY ))
        {
            if(myX - userX > 0)
            {
                move( new Point( myX - 1, myY) );
                faceLeft();
            }
            else
            {
                move( new Point( myX + 1, myY) );
                faceRight();
            }
        }
        else
        {
            if(myY - userY > 0)
            {
                move( new Point( myX, myY - 1) );
                faceDown();
            }
            else
            {
                move( new Point(myX, myY + 1 ));
                faceUp();
            }
        }
    }
}
