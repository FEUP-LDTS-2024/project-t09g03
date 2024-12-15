package com.chickengame.model.game.menu;

public class HelpMenu {
    private final Button back = new Button(500,10, Button.Type.Back);

    public HelpMenu()
    {
        back.select();
    }

    public Button getBack() {
        return back;
    }
}
