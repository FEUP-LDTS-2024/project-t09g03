package com.chickengame.model.menus.buttons;

import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;

public class ButtonTest {
    @Property
    public void testGetters(@ForAll("ButtonTypeArbitrary") Button.Type btype)
    {
        Button button1 = new Button(0,0,btype);
        Button button2 = new Button(10,20,btype);

        Assertions.assertEquals(button1.getPosition().getX(), 0);
        Assertions.assertEquals(button1.getPosition().getY(),0);
        Assertions.assertEquals(button1.getType(),btype);
        Assertions.assertFalse(button1.isSelected());

        Assertions.assertEquals(button2.getPosition().getX(), 10);
        Assertions.assertEquals(button2.getPosition().getY(),20);
        Assertions.assertEquals(button2.getType(),btype);
        button2.setSelected(true);
        Assertions.assertTrue(button2.isSelected());

    }

    @Provide
    Arbitrary<Button.Type> ButtonTypeArbitrary() {
        return Arbitraries.of(Button.Type.Play, Button.Type.Shop, Button.Type.Exit, Button.Type.Back, Button.Type.Next, Button.Type.Previous, Button.Type.Level, Button.Type.LevelMenu, Button.Type.Help);
    }
}
