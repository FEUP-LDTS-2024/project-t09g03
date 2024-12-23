package com.chickengame.model.game.elements;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;

public class ChickenTest {
    @Property
    public void testBooleantrueSetters(@ForAll @IntRange(min = 0,max =8) int skin)
    {
        Chicken chicken = new Chicken(0,0,skin);

        assert chicken.getSkin() == skin;
        chicken.setCharge(true);
        assert chicken.isCharge();
        chicken.setWalking(true);
        assert chicken.isWalking();
    }
    @Test
    public void testBooleanfalseSetters()
    {
        Chicken chicken = new Chicken(0,0,1);

        assert chicken.getSkin() == 1;
        chicken.setCharge(false);
        assert !chicken.isCharge();
        chicken.setWalking(false);
        assert !chicken.isWalking();
    }




}
