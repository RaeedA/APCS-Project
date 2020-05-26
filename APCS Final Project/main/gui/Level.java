package gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Enemy;
import entities.Entity;
import entities.User;
import main.Launcher;

public class Level extends JFrame implements KeyListener
{    
    private ArrayList<Room> rooms;
    private User user;
    private Container pane;
    private GridBagConstraints constraints;
    private int roomNum;
    private long userLevelScore;
    
    
    public Level(String text)
    {
        super(text);
        rooms = new ArrayList<Room>();
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
        /*c.gridx = 1;
        c.gridy = 0;
        
        Room room2 = new Room(10);
        pane.add(room2,c);
        rooms.add( room2 );*/

    }
    
    public Room generateRoom(Room room, boolean isFirst, int roomNum)
    {
        if(!isFirst)
        {
            closeRoom(rooms.get( 0 ));
        }
        constraints.gridx = 0;
        constraints.gridy = 1;
        room.setRoomNum( roomNum );
        pane.add(room, constraints);
        rooms.add( room );
        for(int i = 0; i < Math.random() * 10 + 1; i++)
        {
            (new Enemy(room, new Point((int) (Math.random() * 13) + 1, (int) (Math.random() * 13) + 1))).start();
        }
        constraints.gridx = 0;
        constraints.gridy = 0;
        Top top = new Top(room.getLength());
        top.setRoomNum( roomNum );
        pane.add( top, constraints );
        return room;
    }
    
    public void startGame()
    {
        Room newRoom = new Room(15);
        generateRoom(newRoom, true, 1);
        user = new User(newRoom, new Point(8, newRoom.getMap().getLayout()[0].length - 1));
        user.start();
        roomNum = 1;
        pack();
        setMinimumSize(getSize());
        setSize(getSize().width+30, getSize().height+30);
    }
    
    public void endGame( long userScore )
    {
        for(int i = rooms.size() - 1; i > 0; i--)
        {
            closeRoom(rooms.get( i ));
        }
        userLevelScore = userScore;
        Launcher.getGame().endGame();
    }
    
    public void closeRoom( Room room )
    {
        room.clearEnemies();
        pane.remove( room );
        rooms.remove( room );
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
                //user.setAttacking( true );
                break;
            case KeyEvent.VK_O:
                Enemy ene = new Enemy(rooms.get( 0 ), new Point(1,1));
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
