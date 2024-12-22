package com.chickengame.model.menus.buttons;

import com.chickengame.model.Position;

public class Button
{
    private Position position;
    public enum Type {Play,Shop,Exit, Back, Next, Previous, Level, LevelMenu, Help}
    private final Button.Type type;
    private boolean selected;


    public Button(int x, int y,Type type)
    {
        this.position = new Position(x,y);
        this.type = type;
        this.selected = false;
    }

    public Position getPosition() {
        return position;
    }

    public Button.Type getType()
    {
        return this.type;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }
}
