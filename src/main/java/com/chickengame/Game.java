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
    private final LanternaDraw gui;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() throws IOException {
        while (this.state != null)
        {
            double t1 = System.nanoTime();
            state.step(this, gui);

            try
            {
                this.state.step(this,gui);
                gui.getScreen().refresh();
                if(gui.processKey() == 1)
                {
                    break;
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            double t2 = System.nanoTime();
            System.out.println(1/((t2-t1)/1000000000));
        }
        gui.close();
    }

    public void setState(State state)
    {
        this.state = state;
    }
}