package com.chickengame.model.game.elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    public void testGetters()
    {
        Element element1 = new Element(0,0, 10, 10, "element1");
        Element element2 = new Element(1,1, 11, 11, "element2");


        Assertions.assertEquals(element1.getPosition().getY(), 0);
        Assertions.assertEquals(element1.getPosition().getX() , 0);
        Assertions.assertEquals(element1.getHeight(), 10);
        Assertions.assertEquals(element1.getWidth() ,10);
        Assertions.assertEquals(element1.getName(),"element1");

        Assertions.assertEquals(element2.getPosition().getY(), 1);
        Assertions.assertEquals(element2.getPosition().getX(), 1);
        Assertions.assertEquals(element2.getHeight(), 11);
        Assertions.assertEquals(element2.getWidth(), 11);
        Assertions.assertEquals(element2.getName(),"element2");
    }
}
