package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menu.Menu;
import com.chickengame.model.shop.Shop;
import com.chickengame.state.MenuState;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop location) {
        super(location);
    }
    private int counter = 0;
    private final int max = 3;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {
        System.out.println(counter);
        switch (action)
        {
            case LEFT ->getLocation().previousButton();
            case RIGHT -> getLocation().nextButton();
            case DOWN -> getLocation().getButton(0);
            case SELECT ->
            {
                switch (getLocation().getSelected().getType()) {
                    case Back ->
                    {
                        game.setChickenSkin(counter);
                        game.setState(new MenuState(new Menu()));
                    }
                    case Next ->
                    {
                        changeCounter(getLocation().getNextSkin());
                    }
                    case Previous ->
                    {
                        changeCounter(getLocation().getPrevious());
                    }
                }
            }
        }
    }

    private void changeCounter(int i) {
        counter = i;
    }

}
