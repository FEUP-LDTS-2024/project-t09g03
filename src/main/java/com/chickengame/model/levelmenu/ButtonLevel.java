package com.chickengame.model.levelmenu;

import com.chickengame.model.menu.Button;

public class ButtonLevel extends Button {

    private final int LevelNumber;
    public ButtonLevel(int x, int y, int width, int height, Type type, int levelNumber)
    {
        super(x, y,width,height,type);
        LevelNumber = levelNumber;
    }

    public int getLevel() {
        return LevelNumber;
    }
}
