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
                Level frame = new Level("gui");
            }
            
        });
    }
}
