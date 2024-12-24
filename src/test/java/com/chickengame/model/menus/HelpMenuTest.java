package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelpMenuTest
{
    @Test
    public void testConstructor()
    {
        HelpMenu helpMenu = new HelpMenu();

        Assertions.assertEquals(helpMenu.getBackground(),"helpBackground");

        Assertions.assertEquals(helpMenu.getButtons().getFirst().getPosition().getX(), 500);
        Assertions.assertEquals(helpMenu.getButtons().getFirst().getPosition().getY(),10);

        Assertions.assertTrue(helpMenu.getButtons().getFirst().isSelected());
        Assertions.assertEquals(helpMenu.getButtons().getFirst().getType(), Button.Type.Back);
    }
}
