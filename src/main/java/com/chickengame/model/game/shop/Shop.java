package com.chickengame.model.game.shop;

import com.chickengame.model.game.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Button> buttons;
    private int currentButton = 0;

    public Shop() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new Button(298,275,Button.Type.Back));
        this.buttons.add(new Button(460,225,Button.Type.Next));
        this.buttons.add(new Button(235,225,Button.Type.Previous));
        this.buttons.getFirst().select();
    }

    public List<Button> getButtons()
    {
        return buttons;
    }

    public void nextButton() {
        this.buttons.get(currentButton).unselect();
        currentButton++;
        if (currentButton > this.buttons.size() - 1)
            currentButton = 0;
        this.buttons.get(currentButton).select();
    }

    public void previousButton() {
        this.buttons.get(currentButton).unselect();
        currentButton--;
        if (currentButton < 0)
            currentButton = this.buttons.size() - 1;
        this.buttons.get(currentButton).select();
    }


    public Button getSelected() {
        return buttons.get(currentButton);
    }

    public int getNumberEntries() {
        return this.buttons.size();
    }
}
