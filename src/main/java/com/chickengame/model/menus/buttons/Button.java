package com.chickengame.model.menus.buttons;

import com.chickengame.model.game.elements.InvertedElement;

public class Button extends InvertedElement {
    public enum Type {Play,Shop,Exit, Back, Next, Previous, Level, LevelMenu, Help}
    private final Button.Type type;

    public Button(int x, int y, int width, int height,String name,Type type)
    {
        super(x, y,width,height,name + "Button",false);
        this.type = type;
    }


    public void select()
    {
        super.setInverted(true);
    }
    public Button.Type getType()
    {
        return this.type;
    }
    public void unselect() {
        super.setInverted(false);
    }
}
