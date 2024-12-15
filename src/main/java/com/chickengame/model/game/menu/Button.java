package com.chickengame.model.game.menu;

import com.chickengame.model.game.elements.Element;

public class Button extends Element {
    public enum Type {Play,Shop,Exit, Back, Next, Previous, Level, LevelMenu, Help}
    private final Button.Type type;
    private int selected;
    public Button(int x, int y, Type type) {
        super(x, y);
        this.type = type;
        this.selected = 0;
    }

    public int isSelected() {
        return selected;
    }
    public void select()
    {
        selected = 1;
    }
    public Button.Type getType()
    {
        return this.type;
    }
    public void unselect() {
        this.selected = 0;
    }
}
