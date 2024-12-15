package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.LevelMenuController;
import com.chickengame.model.levelmenu.LevelMenu;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.levelmenu.LevelMenuViewer;

public class LevelMenuState extends State<LevelMenu>{
    public LevelMenuState(LevelMenu location) {
        super(location);
    }

    @Override
    public Viewer<LevelMenu> getStateViewer() {
        return new LevelMenuViewer(getLocation());
    }

    @Override
    public Controller<LevelMenu> getStateController() {
        return new LevelMenuController(getLocation());
    }
}
