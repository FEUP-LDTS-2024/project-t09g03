package com.chickengame.model.shop;

import com.chickengame.model.Menu;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Menu
{
    private static final Position posLeft = new Position(160,125);
    private static final Position posMiddle = new Position(340,125);
    private static final Position posRight = new Position(510,125);

    private final List<Button> buttons = new ArrayList<>();
    private int currentButton = 0;
    private int currentChicken;
    private final int maxChicken = 9;
    private final List<Element> chickens = new ArrayList<>();

    public Shop()
    {
        super.setBackground("shop");
        buttons.add(new Button(302,265,155,50,"back",Button.Type.Back));
        buttons.add(new Button(440,175,55,40,"next",Button.Type.Next));
        buttons.add(new Button(270,175,55,40,"previous",Button.Type.Previous));
        buttons.getFirst().select();
        super.setButtons(buttons);

        for(int i = 0; i < maxChicken;i++)
        {
            chickens.add(new Element(0,0,82,109,"chicken"+i));
        }
        chickens.getFirst().setPosition(posMiddle);
        chickens.get(1).setPosition(posRight);
        chickens.getLast().setPosition(posLeft);
        currentButton = 0;
    }

    public void getButton(int i)
    {
        buttons.get(currentButton).unselect();
        currentButton = i;
        buttons.get(currentButton).select();
    }

    public void nextButton()
    {
        buttons.get(currentButton).unselect();
        currentButton++;
        if (currentButton > this.buttons.size() - 1)
        {
            currentButton = 0;
        }
        buttons.get(currentButton).select();
    }

    public void previousButton()
    {
        buttons.get(currentButton).unselect();
        currentButton--;
        if (currentButton < 0)
        {
            currentButton = this.buttons.size() - 1;
        }
        buttons.get(currentButton).select();
    }

    public Button getSelected()
    {
        return buttons.get(currentButton);
    }

    
    public int getCurrentChicken()
    {
        return currentChicken;
    }

    public int getNextSkin()
    {
        currentChicken = (currentChicken + 1) % maxChicken;
        return currentChicken;
    }

    public int getPrevious()
    {
        currentChicken = (currentChicken-1) <0 ? maxChicken-1: currentChicken-1;
        return currentChicken;
    }

    public Element getMiddleChicken()
    {
        chickens.get(currentChicken).setPosition(posMiddle);
        return chickens.get(currentChicken);
    }

    public Element getRightChicken()
    {
        int right = currentChicken+1;
        if(currentChicken + 1 >= maxChicken)
        {
            right = 0;
        }
        chickens.get(right).setPosition(posRight);
        return chickens.get(right);
    }

    public Element getLeftChicken()
    {
        int left = currentChicken-1;
        if(currentChicken -1 < 0)
        {
            left = maxChicken-1;
        }
        chickens.get(left).setPosition(posLeft);
        return chickens.get(left);
    }
}
