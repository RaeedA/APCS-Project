package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ScoreBoard
{
    private final int mySize;
    private final ImageIcon myImage;
    private long score;
    
    public ScoreBoard(int size)
    {
        mySize = size;
        BufferedImage img = Images.toBufferedImage( Images.getScoreFrame( size ).getImage() );
        Graphics g = img.getGraphics();
        Images.drawText( g, "Score:", size*16, (size*32)/3, true, Color.black, Images.loadFont( 15 ) );
        g.dispose();
        myImage = new ImageIcon(img);
    }
    
    public ImageIcon getImg()
    {
        return myImage;
    }
    
    public ImageIcon update(long newScore)
    {
        score = newScore;
        BufferedImage img = Images.toBufferedImage( myImage.getImage() );
        Graphics g = img.getGraphics();
        g.setColor( Color.white );
        g.fillRect( mySize*16-32, (mySize*64)/3-16, 64, 32 );
        Images.drawText( g, new Long(score).toString(), mySize*16, (mySize*64)/3, true, Color.black, Images.loadFont( 15 ) );
        g.dispose();
        return new ImageIcon(img);
    }
}
