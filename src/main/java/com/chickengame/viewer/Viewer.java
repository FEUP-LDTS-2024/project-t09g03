package com.chickengame.viewer;

import com.chickengame.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private T location;

    public Viewer(T location) {
        this.location = location;
    }

    public T getLocation() {
        return location;
    }

    //wip
    public void draw(GUI gui) throws IOException {
        drawElements(gui);
    }

    //wip
    protected abstract void drawElements(GUI gui);
}
