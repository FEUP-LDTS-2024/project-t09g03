package com.chickengame.state.game;

import com.chickengame.controller.game.MarathonController;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.state.State;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.game.map.MarathonViewer;

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