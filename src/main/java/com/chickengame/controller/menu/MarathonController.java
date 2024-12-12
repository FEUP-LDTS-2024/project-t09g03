package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.Map;

import java.io.IOException;

public class MarathonController extends Controller<Map> {
    public MarathonController(Map location) {
        super(location);
    }

    @Override
    public void step(Game game, GUI.Action action) {
        switch (action)
        {
            case INVERT -> invertChickenGravity();
        }
        movecamera();
    }

    private void invertChickenGravity()
    {

    }

    private void movecamera()
    {
    }




}
