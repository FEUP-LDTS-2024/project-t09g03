package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.*;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.*;

import java.util.ArrayList;
import java.util.List;

public class MarathonViewer extends Viewer<MarathonMap>
{
    private final ChickenViewer chickenViewer = new ChickenViewer(getLocation().getChicken().getType());
    private final List<MapViewer> mapViewerList = new ArrayList<>();
    private final BackgroundViewer backgroundViewer = new BackgroundViewer();


    public MarathonViewer(MarathonMap map)
    {
        super(map);
        for(Map m : map.getMaps())
        {
            mapViewerList.add(new MapViewer(m));
        }

    }
    @Override
    public void drawElements(GUI gui)
    {
        this.drawElements(gui,getLocation().getBackground(), backgroundViewer);
        mapViewerList.get(getLocation().getCurrent()).drawElements(gui);
        mapViewerList.get(getLocation().getNextMap()).drawElements(gui);
        this.drawElements(gui, this.getLocation().getChicken(), chickenViewer);
    }

    private <T extends Element> void drawElements(GUI gui, T elements, ElementViewer<T> viewer)
    {
        viewer.draw(elements,gui);
    }
}
