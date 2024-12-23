package com.chickengame.model.menus;

import com.chickengame.model.game.elements.Element;
import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopMenuTest {
    private ShopMenu shopMenu;

    @BeforeEach
    public void setUp() {
        shopMenu = new ShopMenu();
    }

    @Test
    public void testConstructor() {
        Button selectedButton = shopMenu.getSelected();
        assertEquals(Button.Type.Back, selectedButton.getType());
        assertTrue(selectedButton.isSelected());

        Element middleChicken = shopMenu.getMiddleChicken();
        assertEquals("chicken0", middleChicken.getName());
        assertEquals(340, middleChicken.getPosition().getX());
        assertEquals(125, middleChicken.getPosition().getY());
    }

    @Test
    public void testSelectButton() {
        shopMenu.selectButton(1);
        assertNotEquals(shopMenu.getSelected().getType(), Button.Type.Back);
        assertEquals(Button.Type.Next, shopMenu.getSelected().getType());
    }

    @Test
    public void testNextButton() {
        shopMenu.nextButton();
        shopMenu.nextButton();
        shopMenu.nextButton();
        assertEquals(Button.Type.Back, shopMenu.getSelected().getType());
    }

    @Test
    public void testPreviousButton() {
        for(int i=0; i<7; i++)
        {
            shopMenu.previousButton();
        }
        assertEquals(Button.Type.Previous, shopMenu.getSelected().getType());
    }

    @Test
    public void testGetNextSkin() {
        int initialChicken = shopMenu.getNextSkin();
        assertEquals(1, initialChicken);

        for (int i = 0; i < 7; i++) {
            shopMenu.getNextSkin();
        }
        assertEquals(0, shopMenu.getNextSkin());
    }

    @Test
    public void testGetPreviousSkin() {
        int initialChicken = shopMenu.getPreviousSkin();
        assertEquals(8, initialChicken);

        for (int i = 0; i < 7; i++)
        {
            shopMenu.getPreviousSkin();
        }
        assertEquals(8, shopMenu.getPreviousSkin());
    }

    @Test
    public void testGetMiddleChicken() {
        Element middleChicken = shopMenu.getMiddleChicken();
        assertEquals("chicken0", middleChicken.getName());
        assertEquals(340, middleChicken.getPosition().getX());
        assertEquals(125, middleChicken.getPosition().getY());
    }

    @Test
    public void testGetRightChicken() {
        Element rightChicken = shopMenu.getRightChicken();
        assertEquals("chicken1", rightChicken.getName());
        assertEquals(510, rightChicken.getPosition().getX());
        assertEquals(125, rightChicken.getPosition().getY());
    }

    @Test
    public void testGetLeftChicken() {
        Element leftChicken = shopMenu.getLeftChicken();
        assertEquals("chicken8", leftChicken.getName());
        assertEquals(160, leftChicken.getPosition().getX());
        assertEquals(125, leftChicken.getPosition().getY());
        shopMenu.getPreviousSkin();
        Element leftChicken2 =shopMenu.getLeftChicken();
        assertEquals("chicken7", leftChicken2.getName());
        assertEquals(160, leftChicken2.getPosition().getX());
        assertEquals(125, leftChicken2.getPosition().getY());
    }
}
