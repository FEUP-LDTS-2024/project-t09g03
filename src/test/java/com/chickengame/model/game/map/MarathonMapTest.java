package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarathonMapTest {
    private MarathonMap marathonMap;
    private List<Map> maps;
    private Chicken chicken;

    @BeforeEach
    public void helper() {
        maps = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map mockMap = Mockito.mock(Map.class);
            Mockito.when(mockMap.getSizeX()).thenReturn(i * 10);
            maps.add(mockMap);
        }
        chicken = Mockito.mock(Chicken.class);
        marathonMap = new MarathonMap(maps, chicken);
    }

    @Test
    public void testConstructor() {
        assertNotNull(marathonMap.getCurrent());
        assertNotNull(marathonMap.getNextMap());
        assertEquals(chicken, marathonMap.getChicken());

        Map current = marathonMap.getCurrent();
        Map next = marathonMap.getNextMap();
        assertNotSame(current, next);
        assert maps.contains(current);
        assert maps.contains(next);
        Mockito.verify(next).moveMap(current.getSizeX());
    }

    @Test
    public void testSetNextMap() {
        Map initialCurrent = marathonMap.getCurrent();
        Map initialNext = marathonMap.getNextMap();

        marathonMap.setNextMap();

        assertNotSame(initialCurrent, marathonMap.getCurrent());
        assertNotSame(initialNext, marathonMap.getNextMap());

        Mockito.verify(marathonMap.getNextMap()).moveMap(marathonMap.getCurrent().getSizeX());
    }

    @Test
    public void testException() {
        List<Map> insufficientMaps = List.of(Mockito.mock(Map.class));
        boolean result = false;
        try
        {
            new MarathonMap(insufficientMaps, chicken);
        }
        catch (RuntimeException e)
        {
            result= true;
        }
        assert result;
    }

    @Test
    public void testGetters() {
        assertEquals(chicken, marathonMap.getChicken());
        assertNotNull(marathonMap.getCurrent());
        assertNotNull(marathonMap.getNextMap());
    }
}
