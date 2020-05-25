package screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import gui.Images;
import main.Launcher;

public class EndScreen extends Screen
{
    private ArrayList<Long> scoreBoard;
    private int yDifference;
    public EndScreen()
    {
        super();

        JButton button = new JButton( "Retry", Images.getButton() );
        button.setBounds( 340, 400, 120, 50 );
        button.setFont( Images.loadFont( 14 ) );
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition( JButton.CENTER );
        this.add( button );
        ImageIcon background = new ImageIcon(
            this.getClass().getResource( "DungeonBackground2.gif" ) );
        background.setImage( background.getImage()
            .getScaledInstance( 800, 600, Image.SCALE_DEFAULT ) );
        scoreBoard = Launcher.getGame().getScores();
        JLabel label = new JLabel(background) 
        {
            public void paintComponent( Graphics g )
            {
                super.paintComponent( g );
                Images.drawText( g, "Game Over", 400, 75, true, Color.WHITE, Images.loadFont( 60 ) );
                Images.drawText( g, "HighScores:", 400, 125, true, Color.YELLOW, Images.loadFont( 45 ) );
                yDifference = 50;
                for(Long score : scoreBoard)
                {
                    Images.drawText( g, score.toString(), 400, 125 + yDifference, true, Color.YELLOW, Images.loadFont( 38 ) );
                    yDifference += 45;
                }
            }
        };
        this.getContentPane().add( ( label ) );
        button.addActionListener((new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                setVisible(false);
                Launcher.getGame().getMenu().setVisible( true );
            }
            
        }));
        this.pack();
    }
}
