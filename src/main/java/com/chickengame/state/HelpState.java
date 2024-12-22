package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.HelpController;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.MenuViewer;
import com.chickengame.viewer.Viewer;

public class HelpState extends State<Menu>
{
    public HelpState(HelpMenu location)
    {
        super(location);
    }

    @Override
    public MenuViewer getStateViewer()
    {
        return new MenuViewer(getLocation(), new ButtonViewerFactory(new ImageLoader()));
    }

    @Override
    public HelpController getStateController()
    {
        return new HelpController(getLocation());
    }
}
