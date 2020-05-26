package screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import gui.Images;
import main.Launcher;

@SuppressWarnings("serial")
public class EndScreen extends Screen
{
    private List<Long> scoreBoard;
    private int yDifference;
    private long recentScore;
    private boolean isNewestRecord;
    public EndScreen()
    {
        super();

        JButton button = makeButton("Retry", Images.getButton(), 400, 425, 120, 50, 20);
        this.add( button );
        this.setBackgroundImg( "DungeonBackground2.gif", 800, 600 );
        this.getContentPane().add( ( makeLabel(background) ) );
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
    

    @Override
    protected JLabel makeLabel( ImageIcon backgroundImg )
    {
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
        return label;
    }
    
    
}
