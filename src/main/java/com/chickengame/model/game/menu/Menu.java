package com.chickengame.model.game.menu;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Button> buttons;
    private int currentButton = 0;

    public Menu() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new Button(290,110,Button.Type.Play));
        this.buttons.add(new Button(290,170,Button.Type.Shop));
        this.buttons.add(new Button(290,230,Button.Type.Exit));
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
