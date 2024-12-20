package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.HelpController;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.viewer.menus.MenuViewer;
import com.chickengame.viewer.Viewer;

public class HelpState extends State<Menu>
{
    public HelpState(HelpMenu location)
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
        return new HelpController(getLocation());
    }
}
