package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.StoreController;
import com.chickengame.model.game.map.Store;
import com.chickengame.viewer.store.StoreViewer;
import com.chickengame.viewer.Viewer;

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

