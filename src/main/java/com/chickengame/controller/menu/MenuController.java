package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.game.map.MarathonBuilder;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.model.game.menu.HelpMenu;
import com.chickengame.model.game.menu.Menu;
import com.chickengame.model.game.shop.Shop;
import com.chickengame.model.levelmenu.LevelMenu;
import com.chickengame.state.HelpState;
import com.chickengame.state.LevelMenuState;
import com.chickengame.state.MarathonState;
import com.chickengame.state.ShopState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu location) {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui,GUI.Action action)
    {
        switch (action)
        {
            case UP ->getLocation().previousButton();
            case DOWN -> getLocation().nextButton();
            case SELECT -> {
                try {
                switch (getLocation().getSelected().getType()) {
                    case Exit -> {

                            gui.close();
                                         }
                    case Play -> game.setState(new MarathonState(new MarathonBuilder().createMarathonMap(4, "/maps/", new MapBuilder(), game.getChickenSkin())));
                    case Shop -> game.setState(new ShopState(new Shop()));
                    case LevelMenu -> game.setState(new LevelMenuState(new LevelMenu()));
                    case Help -> game.setState(new HelpState(new HelpMenu()));
                }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
