package com.chickengame.model.levelmenu;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class LevelMenu{
    private final List<Button> buttons = new ArrayList<>();
    private int currentButton = 1;

    public LevelMenu()
    {
        this.buttons.add(new Button(302,265,Button.Type.Back));
        this.buttons.add(new ButtonLevel(200,150,Button.Type.Level, 1));
        this.buttons.add(new ButtonLevel(360,150,Button.Type.Level, 2));
        this.buttons.add(new ButtonLevel(520,150,Button.Type.Level, 3));
        this.buttons.get(1).select();
    }
    public List<Button> getButtons()
    {
        return buttons;
    }

    public Button getCurrentButton() {
        return buttons.get(currentButton);
    }

    public void setCurrentButton(int currentButton) {
        this.currentButton = currentButton;
    }

    public void selectBack()
    {
        unselectall();
        currentButton = 0;
        buttons.getFirst().select();
    }

    public void selectNext()
    {
        unselectall();
        currentButton++;
        if(currentButton >= buttons.size())
        {
            currentButton = 1;
        }
        buttons.get(currentButton).select();
    }
    public void selectPrev()
    {
        unselectall();
        currentButton--;
        if(currentButton<1)
        {
            currentButton = buttons.size()-1;
        }
        buttons.get(currentButton).select();
    }
    private void unselectall()
    {
        for(Button b: buttons)
        {
            b.unselect();
        }
    }


}
