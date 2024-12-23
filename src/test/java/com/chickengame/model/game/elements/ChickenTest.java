package com.chickengame.model.game.elements;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class ChickenTest {
    @Property
    public void testBooleanSetters(@ForAll boolean bool, @ForAll @IntRange(min = 0,max =8) int skin)
    {
        Chicken chicken = new Chicken(0,0,skin);

        assert chicken.getSkin() == skin;
        chicken.setCharge(bool);
        assert chicken.isCharge() == bool;
        chicken.setWalking(bool);
        assert chicken.isWalking() == bool;
    }

}
