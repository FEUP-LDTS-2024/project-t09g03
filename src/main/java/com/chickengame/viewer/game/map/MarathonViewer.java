package com.chickengame.viewer.game.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.*;
import com.chickengame.viewer.game.elements.ChickenViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;


public class MarathonViewer extends Viewer<MarathonMap>
{
    private  MapViewer mapViewer;
    private final BasicTextImage backgroundBasicTextImage;
    private final ChickenViewer chickenViewer;
    private final ElementViewerFactory elementViewerFactory;


    public MarathonViewer(MarathonMap marathonMap, ElementViewerFactory viewerFactory)
    {
        super(marathonMap);
        elementViewerFactory = viewerFactory;
        mapViewer = new MapViewer(marathonMap.getCurrent(),elementViewerFactory);
        backgroundBasicTextImage = viewerFactory.getBackground("background");
        chickenViewer = elementViewerFactory.getChickenViewer(marathonMap.getChicken().getSkin());
    }

    @Override
    public void drawElements(GUI gui)
    {
        gui.drawImage(new Position(0,0),backgroundBasicTextImage);
        mapViewer = new MapViewer(getLocation().getCurrent(),elementViewerFactory);
        mapViewer.drawElements(gui);
        mapViewer = new MapViewer(getLocation().getNextMap(),elementViewerFactory);
        mapViewer.drawElements(gui);
        chickenViewer.draw(gui,getLocation().getChicken());
    }

}
