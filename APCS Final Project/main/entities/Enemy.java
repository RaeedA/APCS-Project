package entities;

import java.awt.Point;

import gui.Images;
import gui.Room;
import main.Launcher;

public class Enemy extends GameCharacter
{
    private int randDecision;
    private int difficulty;
    public Enemy(Room room, Point p)
    {
        super(room, p);
        type = "enemy";
        health = 100;
        difficulty = 30;
        attackDamage = 25;
        
        images = Images.getSkeleton();
        image = images[0];
        score = 10 * difficulty;
        randDecision = (int) (Math.random() * 100);
        room.addEntity( this );
    }
    
    public void update()
    {
        if(room.getUser() == null)
        {
            isAlive = false;
            return;
        }
        else if (randDecision < difficulty)
        {
            moveToPlayer();
            if(randDecision % ((int)(Math.random() *10) + 1 ) == 0)
            {
                attack();
                System.out.println(room.getUser().getHealth());
            }
        }
        else
        {
            idle();
        }
        randDecision = (int) (Math.random() * 250);
    }
    
    public long takeScore()
    {
        long scoreTaken = score;
        score = 0;
        return scoreTaken;
    }
    public void moveToPlayer()
    {
        User user = room.getUser();
        Point userLocation = user.getLocation();
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

    @Override
    protected void successKill(GameCharacter other)
    {
        return;
    }

    @Override
    protected boolean isAgainst( Entity other )
    {
        return other instanceof User;
    }
    
    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }
    
    
    
}
