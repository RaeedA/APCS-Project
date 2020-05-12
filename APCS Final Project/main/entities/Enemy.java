package entities;

import java.awt.Point;

import gui.Images;
import gui.Room;

public class Enemy extends Character
{
    private int randDecision;
    private int difficulty;
    private int score;
    public Enemy(Room room, Point p)
    {
        super(room, p);
        type = "enemy";
        health = 100;
        difficulty = 50;
        images = Images.getSkeleton();
        image = images[0];
        score = 0;
        randDecision = (int) (Math.random() * 100);
        room.addEntity(this);
    }

    @Override
    public void run()
    {
        while (isAlive)
        {
            charSleep( 200 );
            if(health < 0)
            {
                System.out.print( "enemy is dead" );
                isAlive = false;
            }
            else if(randDecision < difficulty)
            {
                update();
                randDecision = randDecision - (int) (Math.random() * 2 + 1);
            }
            else
            {
                idle();
            }
            randDecision = (int) (Math.random() * 100);
        }
        die();
    }
    
    public void update()
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
            }
            else
            {
                move( new Point( myX + 1, myY) );
            }
        }
        else
        {
            if(myY - userY > 0)
            {
                move( new Point( myX, myY - 1) );
            }
            else
            {
                move( new Point(myX, myY + 1 ));
            }
        }
    }
    public int getScore()
    {
        return score;
    }
}
