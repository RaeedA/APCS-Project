package main;

import javax.swing.SwingUtilities;
import gui.*;

public class Launcher
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run()
            {
                Game game = new Game();
            }
            
        });
    }
}
