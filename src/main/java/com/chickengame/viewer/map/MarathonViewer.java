package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.*;
import com.chickengame.viewer.elements.ChickenViewer;
import com.chickengame.viewer.elements.ElementViewer;


public class MarathonViewer extends Viewer<MarathonMap>
{
    private  MapViewer mapViewer;
    private final ElementViewer backgroundViewer;
    private final ChickenViewer chickenViewer;
    private final ElementViewerFactory elementViewerFactory;


    public MarathonViewer(MarathonMap marathonMap, ElementViewerFactory viewerFactory)
    {
        super(marathonMap);
        elementViewerFactory = viewerFactory;
        mapViewer = new MapViewer(getLocation().getCurrent(),elementViewerFactory);
        backgroundViewer = elementViewerFactory.getViewer(getLocation().getBackground().getName());
        chickenViewer = elementViewerFactory.getChickenViewer(getLocation().getChicken().getSkin());
    }

    @Override
    public void drawElements(GUI gui)
    {
        backgroundViewer.draw(gui,getLocation().getBackground());
        mapViewer = new MapViewer(getLocation().getCurrent(),elementViewerFactory);
        mapViewer.drawElements(gui);
        mapViewer = new MapViewer(getLocation().getNextMap(),elementViewerFactory);
        mapViewer.drawElements(gui);
        chickenViewer.draw(gui,getLocation().getChicken());
    }

}
