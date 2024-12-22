package com.chickengame.state.menus;

import com.chickengame.controller.menus.GameEndController;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.state.State;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.MenuViewer;

public class GameEndState extends State<GameEndMenu>
{
    public GameEndState(GameEndMenu location)
    {
        super(location);
    }

    @Override
    public MenuViewer getStateViewer()
    {
        return new MenuViewer(getLocation(), new ButtonViewerFactory(new ImageLoader()));
    }

    @Override
    public GameEndController getStateController()
    {
        return new GameEndController(getLocation());
    }
}
