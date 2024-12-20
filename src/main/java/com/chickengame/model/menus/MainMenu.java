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
        super.setBackground("main");
        buttons.add(new Button(290,110,155,50,"play",Button.Type.Play));
        buttons.add(new Button(290,170,155,50,"level",Button.Type.LevelMenu));
        buttons.add(new Button(290,230,155,50,"shop",Button.Type.Shop));
        buttons.add(new Button(290,290,155,50,"quit",Button.Type.Exit));
        buttons.add(new Button(690,10, 50,50,"help",Button.Type.Help));
        buttons.getFirst().select();
        super.setButtons(buttons);
    }

    public void nextButton()
    {
        buttons.get(currentButton).unselect();
        currentButton++;
        if (currentButton > buttons.size() - 1)
            currentButton = 0;
        buttons.get(currentButton).select();
    }

    public void previousButton()
    {
        buttons.get(currentButton).unselect();
        currentButton--;
        if (currentButton < 0)
        {
            currentButton = buttons.size() - 1;
        }
        buttons.get(currentButton).select();
    }

    public Button getSelected()
    {
        return buttons.get(currentButton);
    }

}
