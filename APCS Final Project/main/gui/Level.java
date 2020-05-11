package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import entities.Enemy;
import entities.Entity;
import entities.User;

public class Level extends JFrame implements KeyListener
{    
    ArrayList<Room> rooms;
    private Entity user;
    
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
        
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        
        Room room1 = new Room(15);
        pane.add(room1,c);
        rooms.add( room1 );
        Enemy e1 = new Enemy(room1, new Point(1,5));
        e1.start();
        user = new User(room1, new Point(8, 12));
        user.start();
        
        /*c.gridx = 1;
        c.gridy = 0;
        
        Room room2 = new Room(10);
        pane.add(room2,c);
        rooms.add( room2 );*/
        
        pack();
        setMinimumSize(getSize());
        setSize(getSize().width+30, getSize().height+30);
        setVisible( true );
    }

    @Override
    public void keyTyped( KeyEvent e )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed( KeyEvent e )
    {
        int key = e.getKeyCode();
        switch(key)
        {
            case KeyEvent.VK_UP:
                ((User)user).setDy(-1);
                break;
            case KeyEvent.VK_DOWN:
                ((User)user).setDy(1);
                break;
            case KeyEvent.VK_RIGHT:
                ((User)user).setDx(1);
                break;
            case KeyEvent.VK_LEFT:
                ((User)user).setDx(-1);
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
                ((User)user).setDy(0);
                break;
            case KeyEvent.VK_DOWN:
                ((User)user).setDy(0);
                break;
            case KeyEvent.VK_RIGHT:
                ((User)user).setDx(0);
                break;
            case KeyEvent.VK_LEFT:
                ((User)user).setDx(0);
                break;
            default:
                break;
        }
        
    }
    
    
    
    
}
