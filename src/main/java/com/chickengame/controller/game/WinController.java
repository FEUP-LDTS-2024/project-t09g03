package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.Win;
import com.chickengame.model.menu.Menu;
import com.chickengame.state.MenuState;

public class WinController extends Controller<Win> {

    public WinController(Win location) {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action) {
        switch (action)
        {
            case SELECT -> game.setState(new MenuState(new Menu()));
        }
    }
}
