package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.MenuController;
import com.chickengame.controller.menu.StoreController;
import com.chickengame.model.game.map.Menu;
import com.chickengame.model.game.map.Store;
import com.chickengame.viewer.StoreViewer;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.game.MenuViewer;

public class StoreState extends State<Store>{

    public StoreState(Store location) {
        super(location);
    }

    @Override
    public Viewer<Store> getStateViewer() {
        return new StoreViewer(getLocation());
    }

    @Override
    public Controller<Store> getStateController() {
        return new StoreController(getLocation());
    }
}

