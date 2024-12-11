package com.chickengame.viewer;

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
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    //wip
    protected abstract void drawElements(GUI gui);
}
