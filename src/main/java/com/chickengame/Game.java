package com.chickengame;


import com.chickengame.gui.LanternaDraw;
import com.chickengame.state.GameState;
import com.chickengame.state.LobbyState;
import com.chickengame.viewer.MenuViewer;

import java.io.IOException;

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
        this.gameState = new LobbyState();
    }
    public void run()
    {
        MenuViewer viewer = new MenuViewer(lanternaDraw, gameState.getMenu());
        while (gameState != null)
        {
            try
            {
                viewer.drawMenu();
                lanternaDraw.getScreen().refresh();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void setGameState(GameState state)
    {
        this.gameState = state;
    }

}