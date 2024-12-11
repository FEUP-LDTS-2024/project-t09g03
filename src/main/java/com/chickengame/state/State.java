package com.chickengame.state;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.gui.LanternaDraw;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private T location;
    private final Controller<T> stateController;
    private final Viewer<T> stateViewer;


    public State(T location) {
        this.location = location;
        this.stateController = getStateController();
        this.stateViewer = getStateViewer();
    }

    public abstract Viewer<T> getStateViewer();

    public abstract Controller<T> getStateController();

    public T getLocation()
    {
        return this.location;
    }
    //wip
    public void step(Game game, LanternaDraw gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }


}
