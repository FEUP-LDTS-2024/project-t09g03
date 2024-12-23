package com.chickengame.model.game.elements;

import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvertedElementTest {

    @Property
    public void testGetters()
    {
        InvertedElement invertedElement1 = new InvertedElement(0,0,10,10, "iElement1", true);
        InvertedElement invertedElement2 = new InvertedElement(1,1,11,11, "iElement2", false);


        Assertions.assertEquals(invertedElement1.getPosition().getX(), 0);
        Assertions.assertEquals(invertedElement1.getPosition().getY(), 0);
        Assertions.assertEquals(invertedElement1.getWidth(), 10);
        Assertions.assertEquals(invertedElement1.getHeight(), 10);
        Assertions.assertEquals(invertedElement1.getName(),"iElement1");

        Assertions.assertTrue(invertedElement1.isInverted());
        invertedElement1.setInverted(false);
        Assertions.assertFalse(invertedElement1.isInverted());
        Assertions.assertFalse(invertedElement2.isInverted());
        invertedElement2.setInverted(true);
        Assertions.assertTrue(invertedElement2.isInverted());

        Assertions.assertEquals(invertedElement2.getPosition().getX() ,1);
        Assertions.assertEquals(invertedElement2.getPosition().getY(), 1);
        Assertions.assertEquals(invertedElement2.getWidth(), 11);
        Assertions.assertEquals(invertedElement2.getHeight(), 11);
        Assertions.assertEquals(invertedElement2.getName(), "iElement2");

    }

}
