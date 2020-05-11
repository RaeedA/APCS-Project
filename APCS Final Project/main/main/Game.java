package main;

import gui.Level;

public class Game
{
    private KeyManager keyManager;
    public Game()
    {
        Level lvl = new Level("gui");
        keyManager = new KeyManager();
        lvl.addKeyListener( keyManager );
    }
}
