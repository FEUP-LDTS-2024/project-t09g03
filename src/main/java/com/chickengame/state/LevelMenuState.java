package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.LevelMenuController;
import com.chickengame.model.Menu;
import com.chickengame.viewer.MenuViewer;
import com.chickengame.viewer.Viewer;

public class LevelMenuState extends State<Menu>{
    public LevelMenuState(Menu location) {
        super(location);
    }

    @Override
    public Viewer<Menu> getStateViewer() {
        return new MenuViewer(getLocation());
    }

    @Override
    public Controller<Menu> getStateController() {
        return new LevelMenuController(getLocation());
    }
}
