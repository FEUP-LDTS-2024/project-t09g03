package com.chickengame.model.game.menu;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Button> buttons;
    private int currentElement = 0;

    public Menu() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new Button(290,110,Button.Type.Play));
        this.buttons.add(new Button(290,170,Button.Type.Shop));
        this.buttons.add(new Button(290,230,Button.Type.Exit));
    }

    public List<Button> getButtons()
    {
        return buttons;
    }
    public void nextEntry() {
        currentElement++;
        if (currentElement > this.buttons.size() - 1)
            currentElement = 0;
    }

    public void previousEntry() {
        currentElement--;
        if (currentElement < 0)
            currentElement = this.buttons.size() - 1;
    }

    public Button getEntry(int i) {
        return buttons.get(i);
    }

    public boolean isSelected(int i) {
        return currentElement == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.buttons.size();
    }
}
