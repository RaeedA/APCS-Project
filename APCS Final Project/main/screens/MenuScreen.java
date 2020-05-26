package screens;

import main.Launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import gui.Images;


@SuppressWarnings("serial")
public class MenuScreen extends Screen
{
    public MenuScreen()
    {
        super();
        
        
        JButton button = makeButton("Start Game", Images.getButton(), 400, 325, 120, 50, 14);
        this.add( button );
        setBackgroundImg("DungeonBackground1.gif", 800, 600);
        this.getContentPane().add( ( makeLabel(background) ) );
        button.addActionListener((new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                setVisible(false);
                Launcher.getGame().startGame();
            }
            
        }));
        this.pack();
    }

    @Override
    protected JLabel makeLabel(ImageIcon backgroundImg)
    {
        JLabel label = new JLabel(backgroundImg) 
        {
            public void paintComponent( Graphics g )
            {
                super.paintComponent( g );
                Images.drawText( g, "Dungeon Crawler", 400, 75, true, Color.WHITE, Images.loadFont( 60 ) );
            }
        };
        return label;
    }
    

}
