package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;

import java.util.ArrayList;
import java.util.List;

public class GameEndMenu extends Menu
{
    public GameEndMenu(String name)
    {
        super(name);

        List<Button> buttons = new ArrayList<>();
        Button back = new Button(290,290,Button.Type.Back);
        back.setSelected(true);
        buttons.add(back);
        super.setButtons(buttons);
    }
}
