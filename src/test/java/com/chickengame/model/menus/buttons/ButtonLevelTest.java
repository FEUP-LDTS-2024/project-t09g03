package com.chickengame.model.menus.buttons;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;

public class ButtonLevelTest {
    @Property
    public void testGetters(@ForAll @IntRange(min = 1, max = 3) int levelNumber)
    {
        ButtonLevel buttonLevel1 = new ButtonLevel(0,0, Button.Type.Level, levelNumber);
        ButtonLevel buttonLevel2 = new ButtonLevel(10,20, Button.Type.Level,levelNumber);

        Assertions.assertEquals(buttonLevel1.getPosition().getX(),0);
        Assertions.assertEquals(buttonLevel1.getPosition().getY(),0);
        Assertions.assertEquals(buttonLevel1.getType(), Button.Type.Level);
        Assertions.assertEquals(buttonLevel1.getLevel(), levelNumber);


        Assertions.assertEquals(buttonLevel2.getPosition().getX(), 10);
        Assertions.assertEquals(buttonLevel2.getPosition().getY(), 20);
        Assertions.assertEquals(buttonLevel2.getType(), Button.Type.Level);
        Assertions.assertEquals(buttonLevel2.getLevel(), levelNumber);


    }
}
