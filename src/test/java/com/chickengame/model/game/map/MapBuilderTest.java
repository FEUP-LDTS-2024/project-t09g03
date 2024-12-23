package com.chickengame.model.game.map;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.InvertedElement;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class MapBuilderTest {
    private Map expecedMap = new Map();
    @Property
    public void createMap(@ForAll int offset)
    {
        MapBuilder mapBuilder = new MapBuilder();
        Map map = mapBuilder.createMap("map/map10.txt", offset);
        for(int i = 0; i < expecedMap.getElements().size(); i++)
        {
            assertEquals(expecedMap.getElements().get(i).getPosition().getX() + offset, map.getElements().get(i).getPosition().getX());
            assertEquals(expecedMap.getElements().get(i).getPosition().getY(), map.getElements().get(i).getPosition().getY());
            assertEquals(expecedMap.getElements().get(i).getWidth(), map.getElements().get(i).getWidth());
            assertEquals(expecedMap.getElements().get(i).getHeight(), map.getElements().get(i).getHeight());
            assertEquals(expecedMap.getElements().get(i).getName(), map.getElements().get(i).getName());
        }

        for(int i = 0; i < expecedMap.getWalls().size(); i++)
        {
            assertEquals(expecedMap.getWalls().get(i).getPosition().getX() + offset, map.getWalls().get(i).getPosition().getX());
            assertEquals(expecedMap.getWalls().get(i).getPosition().getY(), map.getWalls().get(i).getPosition().getY());
            assertEquals(expecedMap.getWalls().get(i).getWidth(), map.getWalls().get(i).getWidth());
            assertEquals(expecedMap.getWalls().get(i).getHeight(), map.getWalls().get(i).getHeight());
            assertEquals(expecedMap.getWalls().get(i).getName(), map.getWalls().get(i).getName());
        }

        for(int i = 0; i < expecedMap.getHarmObjects().size(); i++)
        {
            assertEquals(expecedMap.getHarmObjects().get(i).getPosition().getX() + offset, map.getHarmObjects().get(i).getPosition().getX());
            assertEquals(expecedMap.getHarmObjects().get(i).getPosition().getY(), map.getHarmObjects().get(i).getPosition().getY());
            assertEquals(expecedMap.getHarmObjects().get(i).getWidth(), map.getHarmObjects().get(i).getWidth());
            assertEquals(expecedMap.getHarmObjects().get(i).getHeight(), map.getHarmObjects().get(i).getHeight());
            assertEquals(expecedMap.getHarmObjects().get(i).getName(), map.getHarmObjects().get(i).getName());
        }
        assert map.getSizeX() == 214;

    }

    @Test
    public void invalidPath()
    {
        boolean result = false;
        MapBuilder mapBuilder = new MapBuilder();
        try
        {
            mapBuilder.createMap("invalidPath.txt", 0);
        }catch (RuntimeException e) {
            result = true;
        }
        assert result;
    }

    @Test
    public void invalidElement()
    {
        boolean result = false;
        MapBuilder mapBuilder = new MapBuilder();
        try
        {
            mapBuilder.createMap("map/invalidElement.txt", 0);
        }catch (AssertionError e) {
            result = true;
        }
        assert result;
    }
}
