package com.chickengame.model.game.shop;

import com.chickengame.model.game.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Button> buttons;
    private int currentElement = 0;

    public Shop() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new Button(298,275,Button.Type.Back));
        this.buttons.add(new Button(460,225,Button.Type.Next));
        this.buttons.add(new Button(235,225,Button.Type.Previous));
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

    public boolean isSelectedBack() {
        return isSelected(3);
    }

    public boolean isSelectedNext() {
        return isSelected(4);
    }

    public boolean isSelectedPrevious() {
        return isSelected(5);
    }

    public int getNumberEntries() {
        return this.buttons.size();
    }
}
