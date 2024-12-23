package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevelMapTest {
    @Test
    public void testGetters()
    {
        Map map = new Map();
        Chicken chicken = new Chicken(0,0,0);
        Element element = new Element(10, 10, 10, 10, "finishLine");
        LevelMap levelMap = new LevelMap(map, chicken, element);

        Assertions.assertEquals(levelMap.getChicken(),chicken);
        Assertions.assertEquals(levelMap.getMap(),map);
        Assertions.assertEquals(levelMap.getFinishLine(),element);
    }
}
