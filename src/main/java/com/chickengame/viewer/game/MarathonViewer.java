package com.chickengame.viewer.game;

import com.chickengame.controler.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.HarmObject;
import com.chickengame.model.game.elements.Wall;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.ObjectPainter;

import java.util.List;

public class MarathonViewer
{
    private final GUI gui;
    private final Map map;
    private final ImageHandler imageHandler;
    private ObjectPainter painter;

    public MarathonViewer(GUI gui, Map map)
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
