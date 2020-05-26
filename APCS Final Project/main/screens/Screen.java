package screens;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.Images;
@SuppressWarnings("serial")
public abstract class Screen extends JFrame
{
    protected ImageIcon background;
    public Screen()
    {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    protected JButton makeButton(String text, ImageIcon buttonImg, int xPos, int yPos, int width, int height, int fontSize)
    {
        JButton button = new JButton( text, buttonImg );
        button.setBounds( xPos - (width / 2), yPos - (height / 2), width, height );
        button.setFont( Images.loadFont( fontSize ) );
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition( JButton.CENTER );
        return button;
    }
    
    protected void setBackgroundImg(String path, int width, int height)
    {
        background = new ImageIcon(this.getClass().getResource( path ) );
        background.setImage( background.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT) );
        
    }
    
    protected abstract JLabel makeLabel(ImageIcon backgroundImg);
}
