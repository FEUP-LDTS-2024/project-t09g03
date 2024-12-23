package com.chickengame.model.game.elements;

import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

public class InvertedElementTest {

    @Property
    public void testGetters()
    {
        InvertedElement invertedElement1 = new InvertedElement(0,0,10,10, "iElement1", true);
        InvertedElement invertedElement2 = new InvertedElement(1,1,11,11, "iElement2", false);

        assert invertedElement1.getPosition().getX() == 0;
        assert invertedElement1.getPosition().getY() == 0;
        assert invertedElement1.getWidth() == 10;
        assert invertedElement1.getHeight() == 10;
        assert invertedElement1.getName().equals("iElement1");

        assert invertedElement1.isInverted();

        assert invertedElement2.getPosition().getX() == 1;
        assert invertedElement2.getPosition().getY() == 1;
        assert invertedElement2.getWidth() == 11;
        assert invertedElement2.getHeight() == 11;
        assert invertedElement2.getName().equals("iElement2");
        assert !invertedElement2.isInverted();

    }

}
