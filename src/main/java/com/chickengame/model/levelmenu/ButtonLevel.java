package com.chickengame.model.levelmenu;

import com.chickengame.model.game.menu.Button;

public class ButtonLevel extends Button {

    private final int LevelNumber;
    public ButtonLevel(int x, int y, Type type, int levelNumber) {
        super(x, y, type);
        LevelNumber = levelNumber;
    }

    public int getLevel() {
        return LevelNumber;
    }
}
