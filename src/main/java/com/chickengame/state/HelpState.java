package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.menu.HelpControler;
import com.chickengame.model.menu.HelpMenu;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.menu.HelpViewer;

public class HelpState extends State<HelpMenu>{
    public HelpState(HelpMenu location) {
        super(location);
    }

    @Override
    public Viewer<HelpMenu> getStateViewer() {
        return new HelpViewer(getLocation());
    }

    @Override
    public Controller<HelpMenu> getStateController() {
        return new HelpControler(getLocation());
    }
}
