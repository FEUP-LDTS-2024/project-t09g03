package com.chickengame.viewer;

import com.chickengame.controller.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.*;
import com.chickengame.model.game.map.Map;

import java.util.List;

public class MarathonViewer extends Viewer<Map>
{
    private final ChickenViewer chickenViewer = new ChickenViewer();


    public MarathonViewer(Map map)
    {
        super(map);
    }
    @Override
    public void drawElements(GUI gui)
    {
        drawElements(gui,getLocation().getChicken(), chickenViewer);
    }
    /*
    private final GUI gui;
    private final Map map;
    private final ImageHandler imageHandler;
    private ObjectPainter painter;


    public MarathonViewer(GUI gui, Map map,ImageHandler img,ObjectPainter painter)
    {
        this.gui = gui;
        this.map = map;
        this.imageHandler = img;
        this.painter = painter;
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
     */

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer)
    {
        for(T element : elements)
        {
            viewer.draw(element,gui);
        }
    }


}
