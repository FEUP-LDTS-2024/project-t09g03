package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.ShopController;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.menus.ShopViewer;
import com.chickengame.viewer.Viewer;

public class ShopState extends State<Menu>
{

    public ShopState(Menu location)
    {
        super(location);
    }

    @Override
    public Viewer<Menu> getStateViewer()
    {
        return new ShopViewer(getLocation());
    }

    @Override
    public Controller<Menu> getStateController()
    {
        return new ShopController(getLocation());
    }
}

