package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.game.MarathonController;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.map.MarathonViewer;
import com.chickengame.viewer.Viewer;

public class MarathonState extends State<MarathonMap> {
    public MarathonState(MarathonMap location)
    {
        super(location);
    }

    @Override
    public Viewer<MarathonMap> getStateViewer() {
        return new MarathonViewer(getLocation());
    }

    @Override
    public Controller<MarathonMap> getStateController() {
        return new MarathonController(getLocation());
    }

    @Override
    public MarathonMap getLocation()
    {
        return super.getLocation();
    }
}