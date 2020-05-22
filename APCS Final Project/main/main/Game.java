package main;

import javax.swing.SwingUtilities;

import gui.Level;
import screens.Screen;
import screens.MenuScreen;

public class Game extends Thread
{
    Level lvl;
    MenuScreen menu;
    public Game()
    {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run()
            {
                lvl = new Level("gui");
                menu = new MenuScreen();
                menu.setVisible( true );
                
                //TODO: This will set visibility, etc. Will make changes to Game, Screen, MenuScreen classes
            }
            
        });
        
        
    }
    
    public void run()
    {
        while(true)
        {
            if(menu.startGame())
            {
                menu.setVisible( false );
                lvl.setVisible( true );
            }
        }
    }
    
    public Level getLevel()
    {
        return lvl;
    }
}
