package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menus.ShopController;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.ShopViewer;
import com.chickengame.viewer.Viewer;

public class ShopState extends State<Menu>
{

    public ShopState(Menu location)
    {
        super(location);
    }

    @Override
    public ShopViewer getStateViewer()
    {
        return new ShopViewer(getLocation(), new ButtonViewerFactory(new ImageLoader()));
    }

    @Override
    public ShopController getStateController()
    {
        return new ShopController(getLocation());
    }
}

