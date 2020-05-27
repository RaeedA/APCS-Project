package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import entities.Enemy;
import entities.User;
import main.Launcher;

@SuppressWarnings("serial")
public class Level extends JFrame implements KeyListener
{    
    private Room activeRoom;
    private Room previousRoom;
    private User user;
    private Container pane;
    private GridBagConstraints constraints;
    private long userLevelScore;
    private Top top;
    
    
    public Level(String text)
    {
        super(text);
        addKeyListener( this );
        userLevelScore = 0;
        setup();
    }
    
    public void setup()
    {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        pane = getContentPane();
        pane.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
    }
    
    public Room generateRoom(Room room, boolean isFirst, int roomNum)
    {
        if(!isFirst)
        {
            previousRoom = activeRoom;
            closeRoom(previousRoom);
        }
        constraints.gridx = 0;
        constraints.gridy = 1;
        room.setRoomNum( roomNum );
        pane.add(room, constraints);
        activeRoom = room;
        for(int i = 0; i < Math.random() * 10 + 1; i++)
        {
            (new Enemy(room, new Point((int) (Math.random() * 13) + 1, (int) (Math.random() * 13) + 1))).start();
        }
        constraints.gridx = 0;
        constraints.gridy = 0;
        top = new Top(room.getLength());
        user.setTop(top);
        top.setRoomNum( roomNum );
        pane.add( top, constraints );
        return room;
    }
    
    public void startGame()
    {
        Room newRoom = new Room(15);
        user = new User(newRoom, new Point(8, newRoom.getMap().getLayout()[0].length - 1));
        user.start();
        generateRoom(newRoom, true, 1);
        pack();
        setMinimumSize(getSize());
        setSize(getSize().width+30, getSize().height+30);
        top.update(user);
    }
    
    public void endGame( long userScore )
    {
        if(previousRoom != null)
        {
            closeRoom(previousRoom);
        }
        closeRoom(activeRoom);
        userLevelScore = userScore;
        Launcher.getGame().endGame();
    }
    
    public void closeRoom( Room room )
    {
        room.clearEnemies();
        pane.remove( room );
    }
    
    public long getUserLevelScore()
    {
        return userLevelScore;
    }
    
    @Override
    public void keyTyped( KeyEvent e )
    {
    }

    @Override
    public void keyPressed( KeyEvent e )
    {
        int key = e.getKeyCode();
        switch(key)
        {
            case KeyEvent.VK_UP:
                user.setMoving( true );
                user.setDy(-1);
                user.faceUp();
                break;
            case KeyEvent.VK_DOWN:
                user.setMoving( true );
                user.setDy(1);
                user.faceDown();
                break;
            case KeyEvent.VK_RIGHT:
                user.setMoving( true );
                user.setDx(1);
                user.faceRight();
                break;
            case KeyEvent.VK_LEFT:
                user.setMoving( true );
                user.setDx(-1);
                user.faceLeft();
                break;
            case KeyEvent.VK_Q:
                break;
            case KeyEvent.VK_O:
                Enemy ene = new Enemy(activeRoom, new Point(1,1));
                ene.start();
                break;
            case KeyEvent.VK_X:
                user.setHealth( 0 );
                break;
            default:
                break;
        }
        
    }

    @Override
    public void keyReleased( KeyEvent e )
    {
        int key = e.getKeyCode();
        switch(key)
        {
            case KeyEvent.VK_UP:
                user.setMoving( false );
                user.setDy(0);
                break;
            case KeyEvent.VK_DOWN:
                user.setMoving( false );
                user.setDy(0);
                break;
            case KeyEvent.VK_RIGHT:
                user.setMoving( false );
                user.setDx(0);
                break;
            case KeyEvent.VK_LEFT:
                user.setMoving( false );
                user.setDx(0);
                break;
            case KeyEvent.VK_Q:
                user.setAttacking( true ) ;
                break;
            default:
                break;
        }
        
    }
    
    
    
    
}
