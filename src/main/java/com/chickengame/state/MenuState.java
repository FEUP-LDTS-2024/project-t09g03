package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.MenuController;
import com.chickengame.model.game.map.Menu;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.game.MenuViewer;

public class MenuState extends State<Menu>{
    public MenuState(Menu location) {
        super(location);
    }

    @Override
    public Viewer<Menu> getStateViewer() {
        return new MenuViewer(getLocation());
    }

    @Override
    public Controller<Menu> getStateController() {
        return new MenuController(getLocation());
    }
}
