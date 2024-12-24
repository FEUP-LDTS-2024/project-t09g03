package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;

import java.util.List;

public abstract class Menu
{
    private String background;
    private List<Button> buttons;

    public Menu(String background)
    {
        this.background = background + "Background";
    }

    public List<Button> getButtons()
    {
        return buttons;
    }

    public String getBackground()
    {
        return background;
    }


    public void setButtons(List<Button> buttons)
    {
        this.buttons = buttons;
    }
}
