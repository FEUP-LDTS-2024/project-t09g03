package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.game.MarathonController;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.map.MarathonViewer;
import com.chickengame.viewer.Viewer;

public class MarathonState extends State<MarathonMap>
{
    public MarathonState(MarathonMap location)
    {
        super(location);
    }

    @Override
    public MarathonViewer getStateViewer()
    {
        return new MarathonViewer(getLocation(), new ElementViewerFactory(new ImageLoader()));
    }

    @Override
    public MarathonController getStateController()
    {
        return new MarathonController(getLocation());
    }

}