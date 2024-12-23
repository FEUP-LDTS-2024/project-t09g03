package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    void helper() {
        mainMenu = new MainMenu();
    }

    @Test
    void testConstructor() {
        List<Button> buttons = mainMenu.getButtons();

        assertEquals(5, buttons.size());

        assertEquals(Button.Type.Play, buttons.get(0).getType());
        assertTrue(buttons.get(0).isSelected());

        assertEquals(Button.Type.LevelMenu, buttons.get(1).getType());
        assertFalse(buttons.get(1).isSelected());

        assertEquals(Button.Type.Shop, buttons.get(2).getType());
        assertFalse(buttons.get(2).isSelected());

        assertEquals(Button.Type.Exit, buttons.get(3).getType());
        assertFalse(buttons.get(3).isSelected());

        assertEquals(Button.Type.Help, buttons.get(4).getType());
        assertFalse(buttons.get(4).isSelected());
    }

    @Test
    void testNextButton() {
        mainMenu.nextButton();
        assertEquals(Button.Type.LevelMenu, mainMenu.getSelected().getType());

        mainMenu.nextButton();
        assertEquals(Button.Type.Shop, mainMenu.getSelected().getType());

        mainMenu.nextButton();
        assertEquals(Button.Type.Exit, mainMenu.getSelected().getType());

        mainMenu.nextButton();
        assertEquals(Button.Type.Help, mainMenu.getSelected().getType());

        mainMenu.nextButton();
        assertEquals(Button.Type.Play, mainMenu.getSelected().getType());
    }

    @Test
    void testPreviousButton() {
        mainMenu.previousButton();
        assertEquals(Button.Type.Help, mainMenu.getSelected().getType());

        mainMenu.previousButton();
        assertEquals(Button.Type.Exit, mainMenu.getSelected().getType());

        mainMenu.previousButton();
        assertEquals(Button.Type.Shop, mainMenu.getSelected().getType());

        mainMenu.previousButton();
        assertEquals(Button.Type.LevelMenu, mainMenu.getSelected().getType());

        mainMenu.previousButton();
        assertEquals(Button.Type.Play, mainMenu.getSelected().getType());
    }
}
