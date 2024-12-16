package com.chickengame.model.shop;

import com.chickengame.model.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Button> buttons;
    private int currentButton = 0;
    private int currentChicken = 0;
    private final int maxChicken = 4;

    public Shop() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new Button(302,265,Button.Type.Back));
        this.buttons.add(new Button(440,175,Button.Type.Next));
        this.buttons.add(new Button(270,175,Button.Type.Previous));
        this.buttons.getFirst().select();
    }

    public List<Button> getButtons()
    {
        return buttons;
    }

    public void getButton(int i) {
        this.buttons.get(currentButton).unselect();
        currentButton = i;
        this.buttons.get(currentButton).select();
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

    public int getMaxChicken()
    {
        return maxChicken;
    }

    public Button getSelected() {
        return buttons.get(currentButton);
    }

    public int getNumberEntries() {
        return this.buttons.size();
    }
    
    public int getCurrentChicken() {return this.currentChicken;}

    public int getNextSkin()
    {
        currentChicken = (currentChicken + 1)%maxChicken;
        return currentChicken;
    }
    public int getPrevious()
    {
        currentChicken = (currentChicken-1) <0 ? maxChicken-1: currentChicken-1;
        return currentChicken;
    }

}
