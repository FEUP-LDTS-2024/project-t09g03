package com.chickengame;


import com.chickengame.gui.LanternaDraw;
import com.chickengame.state.MarathonState;
import com.chickengame.state.State;
import com.chickengame.state.LobbyState;
import com.chickengame.viewer.GameViewer;
import com.chickengame.viewer.MenuViewer;

import java.io.IOException;

/** principio singleton: apenas uma instancia da classe*/
public class Game {

    private static Game instance;
    private final LanternaDraw lanternaDraw;
    private MarathonState gameState;

    /**cria uma nova instancia se ela ainda não existir, caso contrario retorna a existente*/
    public static Game getInstance()
    {
        if(instance == null)
        {
            instance =  new Game();
        }
        return instance;
    }

    private Game(){
        this.lanternaDraw = new LanternaDraw();
        try {
            this.gameState = new MarathonState("Menus/Game.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run()
    {
        GameViewer viewer = new GameViewer(lanternaDraw, gameState.getMap());
        while (gameState != null)
        {
            try
            {
                double start = System.currentTimeMillis();
                viewer.drawMap();
                lanternaDraw.getScreen().refresh();
                System.out.println(1/((System.currentTimeMillis()-start)/ 1000));
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}