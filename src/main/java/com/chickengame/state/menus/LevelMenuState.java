package com.chickengame.state.menus;

import com.chickengame.controller.menus.LevelMenuController;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.state.State;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.MenuViewer;

public class LevelMenuState extends State<LevelMenu>
{
    public LevelMenuState(LevelMenu location)
    {
        super(location);
    }

    @Override
    public MenuViewer getStateViewer()
    {
        return new MenuViewer(getLocation(),new ButtonViewerFactory(new ImageLoader()));
    }

    @Override
    public LevelMenuController getStateController()
    {
        return new LevelMenuController(getLocation());
    }
}
