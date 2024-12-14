package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.game.menu.Menu;
import com.chickengame.model.game.shop.Shop;
import com.chickengame.state.MarathonState;
import com.chickengame.state.MenuState;
import com.chickengame.state.ShopState;

import java.io.IOException;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop location) {
        super(location);
    }

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {
        switch (action)
        {
            case LEFT ->getLocation().previousButton();
            case RIGHT -> getLocation().nextButton();
            case SELECT -> {
                switch (getLocation().getSelected().getType()) {
                    case Back -> {
                        game.setState(new MenuState(new Menu()));
                    }
                }

            }
        }

    }

}
