package com.chickengame.viewer;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;

public interface ElementViewer<T extends Element>
{
    void draw(T element, GUI gui);
}
