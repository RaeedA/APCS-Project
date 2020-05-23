package screens;
import java.awt.*;
import javax.swing.JFrame;
import gui.Images;
public abstract class Screen extends JFrame
{
    public Screen()
    {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
