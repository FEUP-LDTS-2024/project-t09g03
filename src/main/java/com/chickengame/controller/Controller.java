package com.chickengame.controller;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.Menu;

import java.io.IOException;

public abstract class Controller<T> {
    private T location;

    public Controller(T location) {
        this.location = location;
    }

    public T getLocation() {
        return location;
    }

    public abstract void step(Game game, GUI.Action action);
}
