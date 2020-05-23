package main;

import javax.swing.SwingUtilities;
import gui.*;

public class Launcher
{
    private static Game game;
    public static void main(String[] args)
    {
        game = new Game();
        game.start();
    }
    
    public static Game getGame()
    {
        return game;
    }
}
