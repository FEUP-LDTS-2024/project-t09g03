package com.chickengame;

import com.chickengame.gui.GUI;
import com.chickengame.gui.LanternaDraw;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.state.menus.MainMenuState;
import com.chickengame.gui.LanternaScreenFactory;
import com.chickengame.state.State;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

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

    private Game(){
        try {
            LanternaScreenFactory lanternaScreenFactory = new LanternaScreenFactory(new DefaultTerminalFactory(), "font/square.ttf",new TerminalSize(750,375));
            this.gui = new LanternaDraw(lanternaScreenFactory.createScreen());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.state = new MainMenuState(new MainMenu());
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
            System.out.println(1/((t2-t1)/1000000000));
        }
        gui.close();
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