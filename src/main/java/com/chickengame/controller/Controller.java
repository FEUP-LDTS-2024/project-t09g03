package com.chickengame.controller;

import com.chickengame.Game;
import com.chickengame.gui.GUI;

public abstract class Controller<T>
{
    private T location;

    public Controller(T location)
    {
        this.location = location;
    }

    public T getLocation()
    {
        return location;
    }

    public abstract void step(Game game,GUI gui, GUI.Action action);
}
