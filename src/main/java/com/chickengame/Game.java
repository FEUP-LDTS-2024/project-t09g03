package com.chickengame;


import com.chickengame.gui.LanternaDraw;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.MarathonState;
import com.chickengame.state.State;
import com.chickengame.viewer.game.MarathonViewer;

import java.io.IOException;

/** principio singleton: apenas uma instancia da classe*/
public class Game {

    private static Game instance;
    private final Gui gui;
    private State state;

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
        this.gui = new LanternaDraw();
        try {
            this.state = new MarathonState(new Map("/menus/Game.txt"));
            //this.state = new MarathonState("/menus/Game.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() throws IOException {
        MarathonViewer viewer = new MarathonViewer(lanternaDraw, this.state.getLocation());
        while (this.state != null)
        {
            long startTime = System.currentTimeMillis();
            state.step(instance, lanternaDraw, startTime);

            try
            {
                viewer.drawMap();
                lanternaDraw.getScreen().refresh();
                if(lanternaDraw.processKey() == 1)
                {
                    break;
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void setState(State state)
    {
        this.state = state;
    }
}