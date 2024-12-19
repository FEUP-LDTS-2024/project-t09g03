package com.chickengame.model.game;

import com.chickengame.model.menu.Button;

public class Win{
    private final Button back;

    public Win()
    {
        this.back = new Button(290,290,155,50,Button.Type.Back);
        this.back.select();

    }

    public Button getBack() {
        return back;
    }
}
