package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.state.MainMenuState;

public class ShopController extends Controller<Menu>
{
    public ShopController(Menu location)
    {
        super(location);
    }

    private int counter = 0;
    private final int max = 8;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action)
    {
        ShopMenu location = (ShopMenu)getLocation();
        switch (action)
        {
            case LEFT -> location.previousButton();
            case RIGHT -> location.nextButton();
            case DOWN -> location.getButton(0);
            case SELECT ->
            {
                switch (location.getSelected().getType()) {
                    case Back ->
                    {
                        game.setChickenSkin(counter);
                        game.setState(new MainMenuState(new MainMenu()));
                    }
                    case Next -> changeCounter(location.getNextSkin());
                    case Previous -> changeCounter(location.getPrevious());
                }
            }
        }
    }

    private void changeCounter(int i)
    {
        counter = i;
    }

}
