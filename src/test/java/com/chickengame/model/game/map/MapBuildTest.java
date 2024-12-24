package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.InvertedElement;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class MapBuildTest
{
    private Map expecedMap = new Map();

    @BeforeEach
    @BeforeProperty
    public void helper()
    {
        expecedMap.getWalls().add(new InvertedElement(10, 20, 24, 47, "candyCane", true));
        expecedMap.getWalls().add(new Element(30, 40, 40, 42, "chocolatePlatform"));
        expecedMap.getWalls().add(new Element(50, 60, 40, 42, "platform"));
        expecedMap.getWalls().add(new Element(70, 80, 20, 20, "cookie"));
        expecedMap.getHarmObjects().add(new InvertedElement(90, 100, 70, 15, "cornSpike", false));
        expecedMap.getHarmObjects().add(new InvertedElement(110, 120, 70, 15, "toblerone", true));
        expecedMap.getWalls().add(new InvertedElement(130, 140, 26, 46, "cupcake", true));
        expecedMap.getWalls().add(new InvertedElement(150, 160, 26, 46, "iceCream", false));
        expecedMap.getHarmObjects().add(new InvertedElement(170, 180, 23, 15, "gummy", true));
        expecedMap.getWalls().add(new InvertedElement(190, 200, 24, 40, "lollipop", false));

        expecedMap.getElements().add(new InvertedElement(10, 20, 24, 47, "candyCane", true));
        expecedMap.getElements().add(new Element(30, 40, 40, 42, "chocolatePlatform"));
        expecedMap.getElements().add(new Element(50, 60, 40, 42, "platform"));
        expecedMap.getElements().add(new Element(70, 80, 20, 20, "cookie"));
        expecedMap.getElements().add(new InvertedElement(90, 100, 70, 15, "cornSpike", false));
        expecedMap.getElements().add(new InvertedElement(110, 120, 70, 15, "toblerone", true));
        expecedMap.getElements().add(new InvertedElement(130, 140, 26, 46, "cupcake", true));
        expecedMap.getElements().add(new InvertedElement(150, 160, 26, 46, "iceCream", false));
        expecedMap.getElements().add(new InvertedElement(170, 180, 23, 15, "gummy", true));
        expecedMap.getElements().add(new InvertedElement(190, 200, 24, 40, "lollipop", false));
    }

    @Test
    public void createMap()
    {
        MapBuilder mapBuilder = new MapBuilder();
        Map map = mapBuilder.createMap("map/map10.txt");
        assert map.getElements().size() == expecedMap.getElements().size();
        for(int i = 0; i < expecedMap.getElements().size(); i++)
        {
            Assertions.assertEquals(expecedMap.getElements().get(i).getPosition().getX(), map.getElements().get(i).getPosition().getX());
            Assertions.assertEquals(expecedMap.getElements().get(i).getPosition().getY(), map.getElements().get(i).getPosition().getY());
            Assertions.assertEquals(expecedMap.getElements().get(i).getWidth(), map.getElements().get(i).getWidth());
            Assertions.assertEquals(expecedMap.getElements().get(i).getHeight(), map.getElements().get(i).getHeight());
            Assertions.assertEquals(expecedMap.getElements().get(i).getName(), map.getElements().get(i).getName());
        }

        for(int i = 0; i < expecedMap.getWalls().size(); i++)
        {
            Assertions.assertEquals(expecedMap.getWalls().get(i).getPosition().getX(), map.getWalls().get(i).getPosition().getX());
            Assertions.assertEquals(expecedMap.getWalls().get(i).getPosition().getY(), map.getWalls().get(i).getPosition().getY());
            Assertions.assertEquals(expecedMap.getWalls().get(i).getWidth(), map.getWalls().get(i).getWidth());
            Assertions.assertEquals(expecedMap.getWalls().get(i).getHeight(), map.getWalls().get(i).getHeight());
            Assertions.assertEquals(expecedMap.getWalls().get(i).getName(), map.getWalls().get(i).getName());
        }

        for(int i = 0; i < expecedMap.getHarmObjects().size(); i++)
        {
            Assertions.assertEquals(expecedMap.getHarmObjects().get(i).getPosition().getX(), map.getHarmObjects().get(i).getPosition().getX());
            Assertions.assertEquals(expecedMap.getHarmObjects().get(i).getPosition().getY(), map.getHarmObjects().get(i).getPosition().getY());
            Assertions.assertEquals(expecedMap.getHarmObjects().get(i).getWidth(), map.getHarmObjects().get(i).getWidth());
            Assertions.assertEquals(expecedMap.getHarmObjects().get(i).getHeight(), map.getHarmObjects().get(i).getHeight());
            Assertions.assertEquals(expecedMap.getHarmObjects().get(i).getName(), map.getHarmObjects().get(i).getName());
        }
        Assertions.assertEquals(map.getSizeX(),5400);
    }

    @Test
    public void invalidPath()
    {
        MapBuilder mapBuilder = new MapBuilder();
        assertThrows(RuntimeException.class, ()->mapBuilder.createMap("invalidPath.txt"));
    }

    @Test
    public void invalidElement()
    {
        MapBuilder mapBuilder = new MapBuilder();
        assertThrows(RuntimeException.class, () -> mapBuilder.createMap("map/invalidElement.txt"));
    }
}
