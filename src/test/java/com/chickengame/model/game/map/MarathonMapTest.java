package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarathonMapTest
{
    private MarathonMap marathonMap;
    private List<Map> maps;
    private Chicken chicken;

    @BeforeEach
    public void helper()
    {
        maps = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            Map mockMap = Mockito.mock(Map.class);
            Mockito.when(mockMap.getSizeX()).thenReturn(i * 10);
            maps.add(mockMap);
        }
        chicken = Mockito.mock(Chicken.class);
        marathonMap = new MarathonMap(maps, chicken);
    }

    @Test
    public void testConstructor()
    {
        assertNotNull(marathonMap.getCurrent());
        assertNotNull(marathonMap.getNextMap());
        assertEquals(chicken, marathonMap.getChicken());

        Map current = marathonMap.getCurrent();
        Map next = marathonMap.getNextMap();
        assertNotSame(current, next);
        Assertions.assertTrue(maps.contains(current));
        Assertions.assertTrue(maps.contains(next));
        Mockito.verify(next).moveMap(current.getSizeX());
    }

    @Test
    public void testSetNextMap()
    {
        Map initialCurrent = marathonMap.getCurrent();
        Map initialNext = marathonMap.getNextMap();

        marathonMap.setNextMap();

        assertNotSame(initialCurrent, marathonMap.getCurrent());
        assertNotSame(initialNext, marathonMap.getNextMap());

        Mockito.verify(marathonMap.getNextMap()).moveMap(marathonMap.getCurrent().getSizeX());
    }

    @Property
    public void testException(@ForAll @IntRange(min= 0, max = 1)int size)
    {
        List insufficientMaps = Mockito.mock(List.class);
        Mockito.when(insufficientMaps.size()).thenReturn(size);
        Assertions.assertThrows(RuntimeException.class , ()-> new MarathonMap(insufficientMaps, chicken));
    }

    @Property
    public void testNotException(@ForAll @IntRange(min = 2, max = 20) int size)
    {
        Assume.that(size != 1);
        maps = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            Map mockMap = Mockito.mock(Map.class);
            Mockito.when(mockMap.getSizeX()).thenReturn(i * 10);
            maps.add(mockMap);
        }
        chicken = Mockito.mock(Chicken.class);
        marathonMap = new MarathonMap(maps, chicken);
    }

    @Test
    public void testGetters() {
        assertEquals(chicken, marathonMap.getChicken());
        assertNotNull(marathonMap.getCurrent());
        assertNotNull(marathonMap.getNextMap());
    }
}
