package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.GameEndController;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.MenuViewer;
import com.chickengame.viewer.Viewer;

public class GameEndState extends State<Menu>
{
    public GameEndState(Menu location)
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
