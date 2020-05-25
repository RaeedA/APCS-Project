package screens;

import main.Launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Images;


public class MenuScreen extends Screen
{
    private boolean gameToStart = false;
    public MenuScreen()
    {
        super();
        
        
        JButton button = new JButton( "Start Game", Images.getButton() );
        button.setBounds( 340, 300, 120, 50 );
        button.setFont( Images.loadFont( 14 ) );
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition( JButton.CENTER );
        this.add( button );
        ImageIcon background = new ImageIcon(
            this.getClass().getResource( "DungeonBackground1.gif" ) );
        background.setImage( background.getImage()
            .getScaledInstance( 800, 600, Image.SCALE_DEFAULT ) );
        JLabel label = new JLabel(background) 
        {
            public void paintComponent( Graphics g )
            {
                super.paintComponent( g );
                Images.drawText( g, "Dungeon Crawler", 400, 75, true, Color.WHITE, Images.loadFont( 60 ) );
            }
        };
        this.getContentPane().add( ( label ) );
        button.addActionListener((new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                setVisible(false);
                Launcher.getGame().getLevel().setVisible( true );
                Launcher.getGame().getLevel().startGame();
            }
            
        }));
        this.pack();
    }
    
    public boolean startGame()
    {
        return gameToStart;
    }

}
