package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;

import java.util.ArrayList;
import java.util.List;

public class GameEndMenu extends Menu
{
    public GameEndMenu(boolean loose)
    {
        super.setBackground("gameEnd",loose);

        List<Button> buttons = new ArrayList<>();
        Button back = new Button(290,290,155,50,"back",Button.Type.Back);
        back.select();
        buttons.add(back);
        super.setButtons(buttons);
    }
}
