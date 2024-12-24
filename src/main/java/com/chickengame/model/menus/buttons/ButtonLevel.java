package com.chickengame.model.menus.buttons;

public class ButtonLevel extends Button
{

    private final int levelNumber;
    public ButtonLevel(int x, int y,Type type, int levelNumber)
    {
        super(x, y,type);
        this.levelNumber = levelNumber;
    }

    public int getLevel()
    {
        return levelNumber;
    }
}
