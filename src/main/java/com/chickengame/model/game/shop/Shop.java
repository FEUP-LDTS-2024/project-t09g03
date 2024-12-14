package com.chickengame.model.game.shop;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Button> buttons;
    private int currentButton = 0;
    private final List<Chicken> chickens;
    private int currentChicken;
    private final int maxChicken = 3;

    public Shop() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new Button(298,275,Button.Type.Back));
        this.buttons.add(new Button(460,225,Button.Type.Next));
        this.buttons.add(new Button(235,225,Button.Type.Previous));
        this.buttons.getFirst().select();
        this.chickens = new ArrayList<>();
        this.chickens.add(new Chicken(250, 250, 0));
        this.chickens.add(new Chicken(300, 300, 0));
        this.chickens.add(new Chicken(350, 350, 0));
    }

    public List<Button> getButtons()
    {
        return buttons;
    }

    public List<Chicken> getChickens() {return chickens;}

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
    
    public int getCurrentChicken() {return this.currentChicken;}

    public void moveLeft() {
        currentChicken = (currentChicken-1+maxChicken)%maxChicken;
    }

    public void moveRight() {
        currentChicken = (currentChicken+1)%maxChicken;
    }
}
