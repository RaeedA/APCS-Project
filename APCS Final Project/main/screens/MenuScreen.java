package screens;

import gui.Images;
import main.Game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class MenuScreen extends Screen
{
    //private boolean gameToStart = false;
    public MenuScreen()
    {
      //TODO: change later
        JButton button = new JButton( "Start Game" );
        button.setBounds( 100, 100, 75, 100 );
        this.add( button );
        ImageIcon background = new ImageIcon(
            this.getClass().getResource( "MenuBackgroundAPCS.gif" ) );
        background.setImage( background.getImage()
            .getScaledInstance( 1744, 1000, Image.SCALE_DEFAULT ) );
        this.getContentPane().add( ( new JLabel( background ) ) );
        
        
        button.addActionListener((new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                
            }
            
        }));
        this.pack();
    }
    
    public boolean startGame()
    {
        
    }

}
