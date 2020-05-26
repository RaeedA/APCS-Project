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
    private long recentScore;
    private boolean isNewestRecord;
    private int numRooms;
    public EndScreen()
    {
        super();

        JButton button = new JButton( "Retry", Images.getButton() );
        button.setBounds( 340, 400, 120, 50 );
        button.setFont( Images.loadFont( 20 ) );
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
                Images.drawText( g, "HighScores:", 400, 135, true, Color.YELLOW, Images.loadFont( 47 ) );
                yDifference = 60;
                Long score;
                for(int i = 0; i < scoreBoard.size() && i < 5; i++)
                {
                    score = scoreBoard.get( i );
                    if(i == 0)
                    {
                        Images.drawText( g, score.toString(), 400, 135 + yDifference, true, Color.YELLOW, Images.loadFont( 42 ) );
                        yDifference += 25;
                    }
                    else
                    {
                        Images.drawText( g, score.toString(), 400, 135 + yDifference, true, Color.YELLOW, Images.loadFont( 36 ) );
                    }
                    yDifference += 35;
                }
                Images.drawText( g, "Your Score: " + recentScore, 400, 525, true, Color.YELLOW, Images.loadFont( 40 ) );
                if(isNewestRecord)
                {
                    Images.drawText( g, "Your Newest Record!", 400, 570, true, Color.YELLOW, Images.loadFont( 20 ) );
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
    
    public void setRecentScore( long recentScore)
    {
        this.recentScore = recentScore;
    }
    
    public void recentIsNewRecord( boolean isNewRecord )
    {
        isNewestRecord = isNewRecord;
    }
}
