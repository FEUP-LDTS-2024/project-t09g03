package com.chickengame;
import com.chickengame.gui.LanternaDraw;
import com.chickengame.state.MarathonState;
import com.chickengame.state.State;
import com.chickengame.viewer.MarathonViewer;

import java.io.IOException;

/** principio singleton: apenas uma instancia da classe*/
public class Game {

    private static Game instance;
    private final LanternaDraw lanternaDraw;
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
        this.lanternaDraw = new LanternaDraw();
        try {
            this.state = new MarathonState("/menus/Game.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run()
    {
        MarathonViewer viewer = new MarathonViewer(lanternaDraw, this.state.getMap());
        while (this.state != null)
        {
            try
            {
                double start = System.nanoTime();
                viewer.drawMap();
                lanternaDraw.getScreen().refresh();
                if(lanternaDraw.processKey() == 1)
                {
                    break;
                }
                double t2 = (System.nanoTime() - start)/1000000000;
                System.out.println(1/t2);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}