package com.chickengame.model.game;

import com.chickengame.model.game.menu.Button;

public class Win{
    private final Button back;

    public Win()
    {
        this.back = new Button(290,290,Button.Type.Back);
        this.back.select();

    }

    public Button getBack() {
        return back;
    }
}
