package com.chickengame.model.menus;

import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.menus.buttons.Button;

import java.util.ArrayList;
import java.util.List;

public class ShopMenu extends Menu
{
    private static final Position posLeft = new Position(160,125);
    private static final Position posMiddle = new Position(340,125);
    private static final Position posRight = new Position(510,125);

    private final List<Button> buttons = new ArrayList<>();
    private int currentButton = 0;
    private int currentChicken;
    private final int maxChicken = 9;
    private final List<Element> chickens = new ArrayList<>();

    public ShopMenu()
    {
        super("shop");
        buttons.add(new Button(302,265,Button.Type.Back));
        buttons.add(new Button(440,175,Button.Type.Next));
        buttons.add(new Button(270,175,Button.Type.Previous));
        buttons.getFirst().setSelected(true);
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

    public void selectButton(int i)
    {
        buttons.get(currentButton).setSelected(false);
        currentButton = i;
        buttons.get(currentButton).setSelected(true);
    }

    public void nextButton()
    {
        buttons.get(currentButton).setSelected(false);
        currentButton++;
        if (currentButton > this.buttons.size() - 1)
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
            currentButton = this.buttons.size() - 1;
        }
        buttons.get(currentButton).setSelected(true);
    }

    public Button getSelected()
    {
        return buttons.get(currentButton);
    }

    public int getNextSkin()
    {
        currentChicken = (currentChicken + 1) % maxChicken;
        return currentChicken;
    }

    public int getPreviousSkin()
    {
        currentChicken--;
        if(currentChicken-1 < 0)
        {
            currentChicken = maxChicken-1;
        }
        return currentChicken;
    }

    public Element getMiddleChicken()
    {
        chickens.get(currentChicken).setPosition(posMiddle);
        return chickens.get(currentChicken);
    }

    public Element getRightChicken()
    {
        int right = (currentChicken+1) % maxChicken;
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
