package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Gui extends JFrame
{    
    ArrayList<Room> rooms;
    
    public Gui(String text)
    {
        super(text);
        rooms = new ArrayList<Room>();
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
        
        Room room1 = new Room(30);
        pane.add(room1,c);
        rooms.add( room1 );
        
        c.gridx = 1;
        c.gridy = 0;
        
        Room room2 = new Room(10);
        pane.add(room2,c);
        rooms.add( room2 );
        
        pack();
        setMinimumSize(getSize());
        setSize(getSize().width+30, getSize().height+30);
        setVisible( true );
    }
}
