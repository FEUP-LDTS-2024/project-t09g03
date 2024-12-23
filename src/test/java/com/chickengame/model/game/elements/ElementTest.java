package com.chickengame.model.game.elements;
import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    public void testGetters()
    {
        Element element1 = new Element(0,0, 10, 10, "element1");
        Element element2 = new Element(1,1, 11, 11, "element2");

        assert element1.getPosition().getY() == 0;
        assert element1.getPosition().getX() == 0;
        assert element1.getHeight() == 10;
        assert element1.getWidth() == 10;
        assert element1.getName().equals("element1");

        assert element2.getPosition().getY() == 1;
        assert element2.getPosition().getX() == 1;
        assert element2.getHeight() == 11;
        assert element2.getWidth() == 11;
        assert element2.getName().equals("element2");
    }
}
