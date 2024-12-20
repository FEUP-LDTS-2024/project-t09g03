package com.chickengame.model.menus;

import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.model.menus.buttons.Button;

import java.util.List;

public abstract class Menu
{
    private Element background;
    private List<Button> buttons;

    public List<Button> getButtons()
    {
        return buttons;
    }

    public Element getBackground()
    {
        return background;
    }

    public void setBackground(String name)
    {
        this.background = new Element(0,0,750,375,name+ "Background");
    }

    public void setBackground(String name,boolean inverted) {
        this.background = new InvertedElement(0,0,750,375,name + "Background",inverted);
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}
