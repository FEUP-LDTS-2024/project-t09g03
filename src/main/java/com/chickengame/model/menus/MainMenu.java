package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu
{
    private final List<Button> buttons = new ArrayList<>();
    private int currentButton = 0;

    public MainMenu()
    {
        super("main");
        buttons.add(new Button(290,110,Button.Type.Play));
        buttons.add(new Button(290,170,Button.Type.LevelMenu));
        buttons.add(new Button(290,230,Button.Type.Shop));
        buttons.add(new Button(290,290,Button.Type.Exit));
        buttons.add(new Button(690,10, Button.Type.Help));
        buttons.getFirst().setSelected(true);
        super.setButtons(buttons);
    }

    public void nextButton()
    {
        buttons.get(currentButton).setSelected(false);
        currentButton++;
        if (currentButton > buttons.size() - 1)
        {
            currentButton = 0;
        }
        buttons.get(currentButton).setSelected(true);
    }

    public void previousButton()
    {
        buttons.get(currentButton).setSelected(false);
        currentButton--;
        if (currentButton < 0)
        {
            currentButton = buttons.size() - 1;
        }
        buttons.get(currentButton).setSelected(true);
    }

    public Button getSelected()
    {
        return buttons.get(currentButton);
    }

}
