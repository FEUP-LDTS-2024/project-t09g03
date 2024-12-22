package com.chickengame.state.menus;

import com.chickengame.controller.menus.HelpController;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.state.State;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.MenuViewer;

public class HelpState extends State<HelpMenu>
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
