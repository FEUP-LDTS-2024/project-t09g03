package com.chickengame.model.menus.buttons;

import net.jqwik.api.*;

public class ButtonTest {
    @Property
    public void testGetters(@ForAll("ButtonTypeArbitrary") Button.Type btype)
    {
        Button button1 = new Button(0,0,btype);
        Button button2 = new Button(10,20,btype);

        assert button1.getPosition().getX() == 0;
        assert button1.getPosition().getY() == 0;
        assert button1.getType() == btype;
        assert !button1.isSelected();

        assert button2.getPosition().getX() == 10;
        assert button2.getPosition().getY() == 20;
        assert button2.getType() == btype;
        button2.setSelected(true);
        assert button2.isSelected();

    }

    @Provide
    Arbitrary<Button.Type> ButtonTypeArbitrary() {
        return Arbitraries.of(Button.Type.Play, Button.Type.Shop, Button.Type.Exit, Button.Type.Back, Button.Type.Next, Button.Type.Previous, Button.Type.Level, Button.Type.LevelMenu, Button.Type.Help);
    }
}
