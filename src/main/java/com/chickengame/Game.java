package com.chickengame;


import com.chickengame.gui.LanternaDraw;
import com.chickengame.state.GameState;

public class Game {

    private static Game instance;
    private final LanternaDraw lanternaDraw;
    private GameState gameState;

    public static Game getInstance()
    {
        if(instance == null)
        {
            instance =  new Game();
        }
        return instance;
    }

    private Game()
    {
        this.lanternaDraw = new LanternaDraw();
    }
    public void run()
    {

    }


}