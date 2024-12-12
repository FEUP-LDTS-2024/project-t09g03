package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.MarathonController;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.map.MarathonViewer;
import com.chickengame.viewer.Viewer;

import java.io.IOException;

public class MarathonState extends State<Map> {
    public MarathonState(Map location) throws IOException
    {
        super(location);
    }

    @Override
    public Viewer<Map> getStateViewer() {
        return new MarathonViewer(getLocation());
    }

    @Override
    public Controller<Map> getStateController() {
        return new MarathonController(getLocation());
    }

    @Override
    public Map getLocation()
    {
        return super.getLocation();
    }
}