package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.game.LevelController;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.map.LevelViewer;

public class LevelState extends State<LevelMap>{
    public LevelState(LevelMap location) {
        super(location);
    }

    @Override
    public Viewer<LevelMap> getStateViewer() {
        return new LevelViewer(getLocation());
    }

    @Override
    public Controller<LevelMap> getStateController() {
        return new LevelController(getLocation());
    }
}
