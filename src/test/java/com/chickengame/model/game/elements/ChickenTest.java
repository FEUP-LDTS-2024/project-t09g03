package com.chickengame.model.game.elements;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChickenTest
{
    @Property
    public void testBooleanTrueSetters(@ForAll @IntRange(min = 0,max =8) int skin)
    {
        Chicken chicken = new Chicken(0,0,skin);

        Assertions.assertEquals(chicken.getSkin(),skin);
        chicken.setCharge(true);
        Assertions.assertTrue(chicken.isCharge());
        chicken.setWalking(true);
        Assertions.assertTrue(chicken.isWalking());
    }

    @Test
    public void testBooleanFalseSetters()
    {
        Chicken chicken = new Chicken(0,0,1);

        Assertions.assertEquals(chicken.getSkin(),1);
        chicken.setCharge(false);
        Assertions.assertFalse(chicken.isCharge());
        chicken.setWalking(false);
        Assertions.assertFalse(chicken.isWalking());
    }
}
