package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.menu.Menu;
import com.chickengame.model.shop.Shop;
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
                    case Play -> game.setState(new MarathonState(new MapBuilder().createMap("/menus/Game.txt", game.getChickenSkin())));
                    case Shop -> game.setState(new ShopState(new Shop()));
                }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
