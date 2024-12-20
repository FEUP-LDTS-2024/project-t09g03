package com.chickengame.state;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private T location;
    private final Controller<T> stateController;
    private final Viewer<T> stateViewer;
    private int chickenType = 0;


    public State(T location) {
        this.location = location;
        this.stateViewer = getStateViewer();
        this.stateController = getStateController();
    }

    public abstract Viewer<T> getStateViewer();

    public abstract Controller<T> getStateController();

    public T getLocation()
    {
        return this.location;
    }

    public void step(Game game,GUI.Action action, GUI gui) throws IOException {
        stateViewer.draw(gui);
        stateController.step(game,gui, action);
    }


    public int getChickenType()
    {
        return chickenType;
    }

    public void setChickenType(int chickenType)
    {
        this.chickenType = chickenType;
    }
}
