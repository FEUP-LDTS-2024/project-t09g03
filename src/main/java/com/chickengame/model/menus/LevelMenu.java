package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;

import java.util.ArrayList;
import java.util.List;

public class LevelMenu extends Menu
{
    private final List<Button> buttons = new ArrayList<>();
    private int currentButton;

    public LevelMenu()
    {
        super("shop");
        buttons.add(new Button(302,265,Button.Type.Back));
        buttons.add(new ButtonLevel(200,150,Button.Type.Level, 1));
        buttons.add(new ButtonLevel(360,150,Button.Type.Level, 2));
        buttons.add(new ButtonLevel(520,150,Button.Type.Level, 3));
        buttons.get(1).setSelected(true);
        currentButton = 1;
        super.setButtons(buttons);
    }

    public Button getCurrentButton()
    {
        return buttons.get(currentButton);
    }


    public void selectBack()
    {
        buttons.get(currentButton).setSelected(false);
        currentButton = 0;
        buttons.getFirst().setSelected(true);
    }

    public void selectNext()
    {
        buttons.get(currentButton).setSelected(false);
        currentButton++;
        if(currentButton >= buttons.size())
        {
            currentButton = 1;
        }
        buttons.get(currentButton).setSelected(true);
    }

    public void selectPrev()
    {
        buttons.get(currentButton).setSelected(false);
        currentButton--;
        if(currentButton<1)
        {
            currentButton = buttons.size()-1;
        }
        buttons.get(currentButton).setSelected(true);
    }
}
