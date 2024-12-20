package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.HelpController;
import com.chickengame.model.Menu;
import com.chickengame.model.menu.HelpMenu;
import com.chickengame.viewer.MenuViewer;
import com.chickengame.viewer.Viewer;

public class HelpState extends State<Menu>{
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
