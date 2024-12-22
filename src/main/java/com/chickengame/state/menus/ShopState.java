package com.chickengame.state.menus;

import com.chickengame.controller.menus.ShopController;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.state.State;
import com.chickengame.viewer.*;
import com.chickengame.viewer.menus.ShopViewer;

public class ShopState extends State<ShopMenu>
{

    public ShopState(ShopMenu location)
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

