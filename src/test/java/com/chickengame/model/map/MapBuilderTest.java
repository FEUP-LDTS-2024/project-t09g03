package com.chickengame.model.map;

import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MapBuilder;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Objects;
import static org.junit.Assert.assertEquals;

public class MapBuilderTest {

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
    @Property
    public void createMap(@ForAll int offset)
    {
        MapBuilder mapBuilder = new MapBuilder();
        Map map = mapBuilder.createMap("map/mapTest.txt", offset);
        for(int i = 0; i < expecedMap.getElements().size(); i++)
        {
            assert expecedMap.getElements().get(i).getPosition().getX() + offset == map.getElements().get(i).getPosition().getX();
            assert expecedMap.getElements().get(i).getPosition().getY() == map.getElements().get(i).getPosition().getY();
            assert expecedMap.getElements().get(i).getWidth() == map.getElements().get(i).getWidth();
            assert expecedMap.getElements().get(i).getHeight() == map.getElements().get(i).getHeight();
            assert Objects.equals(expecedMap.getElements().get(i).getName(), map.getElements().get(i).getName());
        }

        for(int i = 0; i < expecedMap.getWalls().size(); i++)
        {
            assert expecedMap.getWalls().get(i).getPosition().getX() + offset == map.getWalls().get(i).getPosition().getX();
            assert (expecedMap.getWalls().get(i).getPosition().getY() == map.getWalls().get(i).getPosition().getY());
            assert (expecedMap.getWalls().get(i).getWidth() == map.getWalls().get(i).getWidth());
            assert (expecedMap.getWalls().get(i).getHeight() == map.getWalls().get(i).getHeight());
            assert (Objects.equals(expecedMap.getWalls().get(i).getName(), map.getWalls().get(i).getName()));
        }

        for(int i = 0; i < expecedMap.getHarmObjects().size(); i++)
        {
            assert (expecedMap.getHarmObjects().get(i).getPosition().getX() + offset == map.getHarmObjects().get(i).getPosition().getX());
            assert (expecedMap.getHarmObjects().get(i).getPosition().getY() == map.getHarmObjects().get(i).getPosition().getY());
            assert (expecedMap.getHarmObjects().get(i).getWidth() == map.getHarmObjects().get(i).getWidth());
            assert (expecedMap.getHarmObjects().get(i).getHeight() == map.getHarmObjects().get(i).getHeight());
            assert (Objects.equals(expecedMap.getHarmObjects().get(i).getName(), map.getHarmObjects().get(i).getName()));
        }
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
        }catch (RuntimeException e) {
            result = true;
        }
        assert result;
    }


}
