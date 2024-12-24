package com.chickengame.state.game;

import com.chickengame.controller.game.LevelController;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.state.State;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.game.map.LevelViewer;

public class LevelState extends State<LevelMap>
{
    public LevelState(LevelMap location)
    {
        super(location);
    }

    @Override
    public LevelViewer getStateViewer()
    {
        return new LevelViewer(getLocation(),new ElementViewerFactory(new ImageLoader()));
    }

    @Override
    public LevelController getStateController()
    {
        return new LevelController(getLocation());
    }
}
