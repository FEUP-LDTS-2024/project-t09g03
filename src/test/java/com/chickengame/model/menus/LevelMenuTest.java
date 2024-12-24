package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelMenuTest
{
    private LevelMenu levelMenu;

    @BeforeEach
    public void helper()
    {
        levelMenu = new LevelMenu();
    }

    @Test
    public void testConstructor()
    {
        assertEquals(levelMenu.getBackground(), "shopBackground");

        assertEquals(Button.Type.Level, levelMenu.getCurrentButton().getType());
        assertEquals(1, ((ButtonLevel) levelMenu.getCurrentButton()).getLevel());

        assertTrue(levelMenu.getCurrentButton().isSelected());
    }

    @Test
    public void testSelectNext()
    {
        levelMenu.selectNext();
        Button nextButton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Level, nextButton.getType());
        assertEquals(2, ((ButtonLevel) nextButton).getLevel());
        assertTrue(nextButton.isSelected());

        Button previousButton = levelMenu.getButtons().get(1);
        assertFalse(previousButton.isSelected());

        levelMenu.selectNext();
        Button thirdButton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Level, thirdButton.getType());
        assertEquals(3, ((ButtonLevel) thirdButton).getLevel());
        assertTrue(thirdButton.isSelected());

        levelMenu.selectNext();
        Button firstButton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Level, firstButton.getType());
        assertEquals(1, ((ButtonLevel) firstButton).getLevel());
        assertTrue(firstButton.isSelected());
    }

    @Test
    public void testSelectPrev()
    {
        levelMenu.selectPrev();
        Button thirdButton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Level, thirdButton.getType());
        assertEquals(3, ((ButtonLevel) thirdButton).getLevel());
        assertTrue(thirdButton.isSelected());

        Button previousButton = levelMenu.getButtons().get(1);
        assertFalse(previousButton.isSelected());

        levelMenu.selectPrev();
        Button secondButton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Level, secondButton.getType());
        assertEquals(2, ((ButtonLevel) secondButton).getLevel());
        assertTrue(secondButton.isSelected());

        levelMenu.selectPrev();
        Button firstbutton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Level, firstbutton.getType());
        assertEquals(1, ((ButtonLevel) firstbutton).getLevel());
        assertTrue(firstbutton.isSelected());
    }

    @Test
    public void testSelectBack()
    {
        levelMenu.selectBack();
        Button backButton = levelMenu.getCurrentButton();
        assertEquals(Button.Type.Back, backButton.getType());
        assertTrue(backButton.isSelected());

        Button firstButton = levelMenu.getButtons().get(1);
        assertFalse(firstButton.isSelected());
    }
}
