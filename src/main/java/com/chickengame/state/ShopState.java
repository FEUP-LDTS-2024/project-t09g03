package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.ShopController;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.*;
import com.chickengame.viewer.menus.ShopViewer;

public class ShopState extends State<Menu>
{

    public ShopState(Menu location)
    {
        super(location);
    }

    @Override
    public ShopViewer getStateViewer()
    {
        ImageLoader imageLoader = new ImageLoader();
        return new ShopViewer(getLocation(), new ButtonViewerFactory(imageLoader), new ElementViewerFactory(imageLoader));
    }

    @Override
    public ShopController getStateController()
    {
        return new ShopController(getLocation());
    }
}

