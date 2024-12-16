package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.game.WinController;
import com.chickengame.model.game.Win;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.WinViewer;

public class WinState extends State<Win> {
    public WinState(Win location) {
        super(location);
    }

    @Override
    public Viewer<Win> getStateViewer() {
        return new WinViewer(getLocation());
    }

    @Override
    public Controller<Win> getStateController() {
        return new WinController(getLocation());
    }
}
