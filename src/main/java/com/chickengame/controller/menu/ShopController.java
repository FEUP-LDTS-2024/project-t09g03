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
    private int counter = 0;
    private final int max = 3;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {
        switch (action)
        {
            case LEFT ->getLocation().previousButton();
            case RIGHT -> getLocation().nextButton();
            case SELECT ->
            {
                switch (getLocation().getSelected().getType()) {
                    case Back ->
                    {
                        game.getState().setChickenType(counter);
                        game.setState(new MenuState(new Menu()));
                    }
                    case Next ->
                    {

                        changeCounter(1);
                    }
                    case Previous ->
                    {
                        changeCounter(-1);
                    }
                }
            }
        }
    }

    private void changeCounter(int i) {
        counter+=i;
        switch (counter)
        {
            case -1 -> counter = max-1;
            case max -> counter = 0;

        }
    }

}
