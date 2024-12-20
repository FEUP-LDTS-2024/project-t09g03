package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.state.MainMenuState;

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
            case SELECT -> game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
