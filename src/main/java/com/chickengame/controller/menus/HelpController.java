package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.state.menus.MainMenuState;

import java.util.Objects;

public class HelpController extends Controller<HelpMenu>
{

    public HelpController(HelpMenu location)
    {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        if (Objects.requireNonNull(action) == GUI.Action.SELECT)
        {
            game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
