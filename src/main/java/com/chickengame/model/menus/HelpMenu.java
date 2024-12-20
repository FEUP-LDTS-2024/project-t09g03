package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;

import java.util.ArrayList;
import java.util.List;

public class HelpMenu extends Menu
{
    public HelpMenu()
    {
        super.setBackground("help");

        List<Button> buttons = new ArrayList<>();
        Button back = new Button(500,10,155,55,"back",Button.Type.Back);
        back.select();
        buttons.add(back);
        super.setButtons(buttons);
    }

}
