package com.chickengame.viewer;

import com.chickengame.gui.GUI;

public interface ObjectViewer<T>
{
    public void draw(GUI gui, T object);
}
