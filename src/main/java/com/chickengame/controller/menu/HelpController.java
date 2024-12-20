package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Menu;
import com.chickengame.model.menu.MainMenu;
import com.chickengame.state.MenuState;

public class HelpController extends Controller<Menu>
{

    public HelpController(Menu location)
    {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        switch (action)
        {
            case SELECT -> game.setState(new MenuState(new MainMenu()));
        }
    }
}
