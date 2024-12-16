package com.chickengame.model.menu;

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
