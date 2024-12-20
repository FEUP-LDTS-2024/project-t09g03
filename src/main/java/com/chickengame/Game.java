package com.chickengame;


import com.chickengame.gui.GUI;
import com.chickengame.gui.LanternaDraw;
import com.chickengame.model.menu.MainMenu;
import com.chickengame.state.MenuState;
import com.chickengame.state.State;

import java.io.IOException;

public class Game {

    private static Game instance;
    private final GUI gui;
    private State state;
    private int chickenSkin = 0;

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
        this.gui = new LanternaDraw();
        this.state = new MenuState(new MainMenu());
    }

    public void run() throws IOException {
        while (this.state != null)
        {
            double t1 = System.nanoTime();
            try
            {
                GUI.Action action = gui.getNextAction();
                if(action == GUI.Action.QUIT)
                {
                    break;
                }
                this.state.step(this,action,gui);

            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            double t2 = System.nanoTime();
            //System.out.println(1/((t2-t1)/1000000000));
        }
        gui.close();
    }

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public int getChickenSkin() {
        return chickenSkin;
    }

    public void setChickenSkin(int chickenSkin) {
        this.chickenSkin = chickenSkin;
    }
}