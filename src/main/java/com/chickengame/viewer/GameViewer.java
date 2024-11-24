package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.elements.Background;
import com.chickengame.model.elements.Chicken;
import com.chickengame.model.elements.HarmObject;
import com.chickengame.model.elements.Wall;
import com.chickengame.model.map.Map;
import com.chickengame.state.State;

import java.util.List;

public class GameViewer
{
    private final GUI gui;
    private final Map map;
    private final ImageHandler imageHandler;
    private ObjectPainter painter;

    public GameViewer(GUI gui, Map map)
    {
        this.gui = gui;
        this.map = map;
        this.imageHandler = new ImageHandler();
        this.painter = new ObjectPainter();
    }

    public void drawMap()
    {
        drawBackground();
        drawChicken();
        drawWalls();
        drawHarmObjects();
    }
    private void drawChicken()
    {
        Chicken chicken = this.map.getChicken();
        painter.draw(gui,imageHandler,chicken);
    }

    private void drawBackground()
    {
        Background background = this.map.getBackground();
        painter.draw(gui,imageHandler,background);
    }

    private void drawWalls()
    {
        List<Wall> walls = this.map.getWalls();
        for(Wall wall : walls)
        {
            painter.draw(gui,imageHandler,wall);
        }
    }

    private void drawHarmObjects()
    {
        List<HarmObject> harmObjects = this.map.getHarmObjects();
        for(HarmObject harmObject : harmObjects)
        {
            painter.draw(gui,imageHandler,harmObject);
        }
    }

}
