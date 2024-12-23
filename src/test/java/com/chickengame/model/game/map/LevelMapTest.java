package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.model.game.map.Map;
import org.junit.jupiter.api.Test;

public class LevelMapTest {
    @Test
    public void testGetters()
    {
        Map map = new Map();
        Chicken chicken = new Chicken(0,0,0);
        Element element = new Element(10, 10, 10, 10, "finishLine");
        LevelMap levelMap = new LevelMap(map, chicken, element);

        assert levelMap.getChicken() == chicken;
        assert levelMap.getMap() == map;
        assert levelMap.getFinishLine() == element;
    }
}
