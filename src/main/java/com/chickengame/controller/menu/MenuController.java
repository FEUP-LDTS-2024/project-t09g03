package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.game.map.Menu;
import com.chickengame.state.MarathonState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu location) {
        super(location);
    }

    @Override
    public void step(Game game, GUI.Action action) {

    }

}
