package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class LevelMapBuilderTest {
    private LevelMap expectedLevelMap;

    @Property
    public void createLevelMap(@ForAll @IntRange(min = 0, max = 8) int skin)
    {
        LevelMapBuilder levelMapBuilder = new LevelMapBuilder();
        MapBuilder mapBuilder = Mockito.mock(MapBuilder.class);
        Mockito.when(mapBuilder.createMap(anyString(), anyInt())).thenReturn(new Map());
        this.expectedLevelMap = new LevelMap(mapBuilder.createMap("map/map10.txt",0), new Chicken(200,300,skin), new Element(5440,30,40,375,"finishLine"));
        LevelMap levelMap = levelMapBuilder.createLevelMap("map/", mapBuilder, skin, 10);

        Assertions.assertNotNull(levelMap.getMap());
        Assertions.assertEquals(expectedLevelMap.getChicken().getSkin(), skin);
        Mockito.verify(mapBuilder, Mockito.times(2)).createMap("map/map10.txt",0);
        assertEquals(expectedLevelMap.getChicken().getPosition().getX(), levelMap.getChicken().getPosition().getX());
        assertEquals(expectedLevelMap.getChicken().getPosition().getY(), levelMap.getChicken().getPosition().getY());
        assertEquals(expectedLevelMap.getChicken().getSkin(), levelMap.getChicken().getSkin());
        assertEquals(expectedLevelMap.getFinishLine().getPosition().getX(), levelMap.getFinishLine().getPosition().getX());
        assertEquals(expectedLevelMap.getFinishLine().getPosition().getY(), levelMap.getFinishLine().getPosition().getY());
    }
}
