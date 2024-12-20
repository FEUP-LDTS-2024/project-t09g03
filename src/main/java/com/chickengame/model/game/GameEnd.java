package com.chickengame.model.game;

import com.chickengame.model.Menu;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.model.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class GameEnd extends Menu
{
    public GameEnd(boolean loose)
    {
        super.setBackground("gameEnd",loose);

        List<Button> buttons = new ArrayList<>();
        Button back = new Button(290,290,155,50,"back",Button.Type.Back);
        back.select();
        buttons.add(back);
        super.setButtons(buttons);
    }
}
