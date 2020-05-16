package main;

import javax.swing.SwingUtilities;

import gui.Level;
import screens.Screen;
import screens.MenuScreen;

public class Game
{
    Level lvl;
    public Game()
    {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run()
            {
                lvl = new Level("gui");
                //TODO: Change for OOP
                MenuScreen menu = new MenuScreen();
                menu.setVisible( true );
                
                //TODO: This will set visibility, etc. Will make changes to Game, Screen, MenuScreen classes
            }
            
        });
        
        
    }
    
    public Level getLevel()
    {
        return lvl;
    }
}
