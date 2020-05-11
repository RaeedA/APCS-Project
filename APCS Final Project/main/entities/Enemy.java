package entities;

import java.awt.Point;
import gui.Images;
import gui.Room;

public class Enemy extends Character
{
    private int randDecision;
    private int difficulty;
    public Enemy(Room room, Point p)
    {
        super(room, p);
        iconNum = (int)(Math.random() * 4) -1;
        image = Images.getSkeleton()[0];
        type = "enemy";
        room.addEntity(this);
        //TODO: base randDEcision on difficuly
        difficulty = 5;
        randDecision = (int) (Math.random() * 100);
    }

    @Override
    public void run()
    {
        while (true)
        {
            if(randDecision < 0)
            {
                randDecision = (int) (Math.random() * 100);
            }
            else if(randDecision < difficulty)
            {
                charSleep( 500 );
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
    
    public void idle()
    {
        iconNum++;
        if( iconNum == 4)
        {
            iconNum = 0;
        }
        room.redraw( this, Images.getSkeleton()[ iconNum ]);
    }
    

}
