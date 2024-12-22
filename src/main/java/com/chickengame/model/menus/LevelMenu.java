package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;

import java.util.ArrayList;
import java.util.List;

public class LevelMenu extends Menu
{
    private final List<Button> buttons = new ArrayList<>();
    private int currentButton = 1;

    public LevelMenu()
    {
        super.setBackground("shop");
        buttons.add(new Button(302,265,150,50,"back",Button.Type.Back));
        buttons.add(new ButtonLevel(200,150,50,50,Button.Type.Level, 1));
        buttons.add(new ButtonLevel(360,150,50,50,Button.Type.Level, 2));
        buttons.add(new ButtonLevel(520,150,50,50,Button.Type.Level, 3));
        buttons.get(1).select();
        super.setButtons(buttons);
    }

    public Button getCurrentButton() {
        return buttons.get(currentButton);
    }


    public void selectBack()
    {
        unselectAll();
        currentButton = 0;
        buttons.getFirst().select();
    }

    public void selectNext()
    {
        unselectAll();
        currentButton++;
        if(currentButton >= buttons.size())
        {
            currentButton = 1;
        }
        buttons.get(currentButton).select();
    }
    public void selectPrev()
    {
        unselectAll();
        currentButton--;
        if(currentButton<1)
        {
            currentButton = buttons.size()-1;
        }
        buttons.get(currentButton).select();
    }
    private void unselectAll()
    {
        for(Button button : buttons)
        {
            button.unselect();
        }
    }


}
