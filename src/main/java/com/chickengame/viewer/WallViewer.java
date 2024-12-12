package com.chickengame.viewer;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Wall;

import java.util.List;

public class WallViewer implements ElementViewer<Wall>
{
    @Override
    public void draw(Wall wall, GUI gui)
    {

        painter.draw(gui,imageHandler,wall);
    }
}
