package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.menu.Button;
import com.chickengame.model.game.menu.HelpMenu;
import com.chickengame.model.game.menu.Menu;
import com.chickengame.state.MenuState;

public class HelpControler extends Controller<HelpMenu> {

    public HelpControler(HelpMenu location) {
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
