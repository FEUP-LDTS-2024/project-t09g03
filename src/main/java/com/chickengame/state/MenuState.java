package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.MainMenuController;
import com.chickengame.model.Menu;
import com.chickengame.viewer.MenuViewer;
import com.chickengame.viewer.Viewer;

public class MenuState extends State<Menu>
{
    public MenuState(Menu location)
    {
        super(location);
    }

    @Override
    public Viewer<Menu> getStateViewer()
    {
        return new MenuViewer(getLocation());
    }

    @Override
    public Controller<Menu> getStateController()
    {
        return new MainMenuController(getLocation());
    }
}
