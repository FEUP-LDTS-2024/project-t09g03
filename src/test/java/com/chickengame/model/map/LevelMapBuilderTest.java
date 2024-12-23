package com.chickengame.model.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.model.game.map.LevelMapBuilder;
import com.chickengame.model.game.map.MapBuilder;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelMapBuilderTest {
    private LevelMap expectedLevelMap;

    @Property
    public void createLevelMap(@ForAll @IntRange(min = 0, max = 8) int skin)
    {
        LevelMapBuilder levelMapBuilder = new LevelMapBuilder();
        MapBuilder mapBuilder = Mockito.mock(MapBuilder.class);
        this.expectedLevelMap = new LevelMap(mapBuilder.createMap("map/map10.txt",0), new Chicken(200,300,skin), new Element(5440,30,40,375,"finishLine"));
        LevelMap levelMap = levelMapBuilder.createLevelMap("map/", mapBuilder, skin, 10);

        Mockito.verify(mapBuilder, Mockito.times(2)).createMap("map/map10.txt",0);
        assertEquals(expectedLevelMap.getChicken().getPosition().getX(), levelMap.getChicken().getPosition().getX());
        assertEquals(expectedLevelMap.getChicken().getPosition().getY(), levelMap.getChicken().getPosition().getY());
        assertEquals(expectedLevelMap.getChicken().getSkin(), levelMap.getChicken().getSkin());
        assertEquals(expectedLevelMap.getFinishLine().getPosition().getX(), levelMap.getFinishLine().getPosition().getX());
        assertEquals(expectedLevelMap.getFinishLine().getPosition().getY(), levelMap.getFinishLine().getPosition().getY());
    }
}
