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
    }

    @Override
    public void run()
    {
        while (isAlive)
        {
            if(health < 0)
            {
                isAlive = false;
                System.out.print( "enemy is dead" );
            }
            else if(randDecision < 0)
            {
                randDecision = (int) (Math.random() * 100);
            }
            else if(randDecision < difficulty)
            {
                charSleep( 400 );
                update();
                randDecision = randDecision - (int) (Math.random() * 2 + 1);
            }
            else
            {
                charSleep( 200 );
                idle();
                randDecision--;
            }
        }
        
        room.addEntity(this);
    }
    
    public void update()
    {
        if(randDecision < difficulty)
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
}
