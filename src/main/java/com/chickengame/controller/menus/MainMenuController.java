package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.game.map.MarathonBuilder;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.state.HelpState;
import com.chickengame.state.LevelMenuState;
import com.chickengame.state.MarathonState;
import com.chickengame.state.ShopState;

import java.io.IOException;

public class MainMenuController extends Controller<Menu>
{
    public MainMenuController(Menu location)
    {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui,GUI.Action action)
    {
        MainMenu location = (MainMenu) getLocation();
        switch (action)
        {
            case UP -> location.previousButton();
            case DOWN -> location.nextButton();
            case SELECT ->
            {
                try
                {
                    switch (location.getSelected().getType())
                    {
                        case Exit -> gui.close();
                        case Play -> game.setState(new MarathonState(new MarathonBuilder().createMarathonMap(3, "/maps/", new MapBuilder(), game.getChickenSkin())));
                        case Shop -> game.setState(new ShopState(new ShopMenu()));
                        case LevelMenu -> game.setState(new LevelMenuState(new LevelMenu()));
                        case Help -> game.setState(new HelpState(new HelpMenu()));
                    }
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
