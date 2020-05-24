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

public class Level extends JFrame implements KeyListener
{    
    private ArrayList<Room> rooms;
    private User user;
    private Container pane;
    private GridBagConstraints constraints;
    private int roomNum;
    
    
    public Level(String text)
    {
        super(text);
        rooms = new ArrayList<Room>();
        addKeyListener( this );
        setup();
    }
    
    public void setup()
    {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        pane = getContentPane();
        pane.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        roomNum = 1;
        /*c.gridx = 1;
        c.gridy = 0;
        
        Room room2 = new Room(10);
        pane.add(room2,c);
        rooms.add( room2 );*/

    }
    
    public Room generateRoom(Room room, int roomNum)
    {
        if(roomNum > 1)
        {
            pane.remove( rooms.get( roomNum - 2 ) );
            rooms.remove( roomNum - 2 );
        }
        constraints.gridx = 0;
        constraints.gridy = 1;
        pane.add(room, constraints);
        rooms.add( room );
        for(int i = 0; i < Math.random() * 10 + 1; i++)
        {
            (new Enemy(room, new Point((int) (Math.random() * 13) + 1, (int) (Math.random() * 13) + 1))).start();
        }
        constraints.gridx = 0;
        constraints.gridy = 0;
        Top top = new Top(room.getLength());
        pane.add( top, constraints );
        return room;
    }
    
    public void startGame()
    {
        Room newRoom = new Room(15);
        generateRoom(newRoom, 1);
        user = new User(newRoom, new Point(8, newRoom.getMap().getLayout()[0].length - 1));
        user.start();
        pack();
        setMinimumSize(getSize());
        setSize(getSize().width+30, getSize().height+30);
    }
    public Room getRoom(int index)
    {
        return rooms.get( index );
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
                user.setAttacking( true );
                break;
            case KeyEvent.VK_O:
                Enemy ene = new Enemy(rooms.get( 0 ), new Point(1,1));
                ene.start();
                break;
            case KeyEvent.VK_X:
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
                user.setAttacking( false) ;
                break;
            default:
                break;
        }
        
    }
    
    
    
    
}
