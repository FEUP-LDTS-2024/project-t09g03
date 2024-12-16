package com.chickengame.model.game;

import com.chickengame.model.game.menu.Button;

public class GameOver {
    private final Button back;

    public GameOver()
    {
        this.back = new Button(290,290,Button.Type.Back);
        this.back.select();
    }


    public Button getBack() {
        return back;
    }
}
