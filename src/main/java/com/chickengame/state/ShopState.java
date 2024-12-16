package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.ShopController;
import com.chickengame.model.shop.Shop;
import com.chickengame.viewer.shop.ShopViewer;
import com.chickengame.viewer.Viewer;

public class ShopState extends State<Shop>{

    public ShopState(Shop location) {
        super(location);
    }

    @Override
    public Viewer<Shop> getStateViewer() {
        return new ShopViewer(getLocation());
    }

    @Override
    public Controller<Shop> getStateController() {
        return new ShopController(getLocation());
    }
}

