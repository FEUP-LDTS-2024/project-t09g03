package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.state.menus.MainMenuState;

public class ShopController extends Controller<ShopMenu>
{
    public ShopController(ShopMenu location)
    {
        super(location);
    }

    private int counter = 0;
    private final int max = 8;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action)
    {
        switch (action)
        {
            case LEFT -> getLocation().previousButton();
            case RIGHT -> getLocation().nextButton();
            case DOWN -> getLocation().selectButton(0);
            case SELECT ->
            {
                switch (getLocation().getSelected().getType())
                {
                    case Back ->
                    {
                        game.setChickenSkin(counter);
                        game.setState(new MainMenuState(new MainMenu()));
                    }
                    case Next -> changeCounter(getLocation().getNextSkin());
                    case Previous -> changeCounter(getLocation().getPreviousSkin());
                }
            }
        }
    }

    private void changeCounter(int i)
    {
        counter = i;
    }

}
