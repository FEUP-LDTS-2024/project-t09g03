package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.menus.MenuViewer;
import com.chickengame.viewer.Viewer;

public class MainMenuState extends State<Menu>
{
    public MainMenuState(Menu location)
    {
        super(location);
    }

    @Override
    public Viewer<Menu> getStateViewer()
    {
        return new MenuViewer(getLocation(), new ElementViewerFactory());
    }

    @Override
    public Controller<Menu> getStateController()
    {
        return new MainMenuController(getLocation());
    }
}
