package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Element;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapTest
{
    private Map map;
    private List<Element> harmObjects;

    @BeforeEach
    public void helper()
    {
        Map map = new Map();
        map.getWalls().add(new Element(0,0,2,2,"wall"));
        map.getWalls().add(new Element(7,0,1,1,"wall"));
        map.getWalls().add(new Element(3,3,4,1,"wall"));
        map.getWalls().add(new Element(1,8,2,2,"wall"));

        map.getHarmObjects().add(new Element(4,6,3,1,"harmObject"));
        map.getHarmObjects().add(new Element(9,8,1,2,"harmObject"));
        map.getHarmObjects().add(new Element(10,1,2,1,"harmObject"));

        map.getElements().add(new Element(0,0,2,2,"wall"));
        map.getElements().add(new Element(7,0,1,1,"wall"));
        map.getElements().add(new Element(3,3,4,1,"wall"));
        map.getElements().add(new Element(1,8,2,2,"wall"));
        map.getElements().add(new Element(4,6,3,1,"harmObject"));
        map.getElements().add(new Element(9,8,1,2,"harmObject"));
        map.getElements().add(new Element(10,1,2,1,"harmObject"));
        this.map = map;
    }

    @Test
    void collidesHarmObject()
    {
        Assertions.assertTrue(map.collidesHarmObject(5,6,7,9));
        Assertions.assertTrue(map.collidesHarmObject(4,6,7,9));
        Assertions.assertTrue(map.collidesHarmObject(8,10,7,9));
        Assertions.assertFalse(map.collidesHarmObject(4,6,9,11));
        Assertions.assertFalse(map.collidesHarmObject(7,9,2,4));
    }

    @Test
    void collidesUp()
    {
        Assertions.assertFalse(map.collidesUp(0,2,3));
        Assertions.assertFalse(map.collidesUp(2,4,0));
        Assertions.assertFalse(map.collidesUp(1,3,3));
        Assertions.assertTrue(map.collidesUp(0,2,2));
        Assertions.assertTrue(map.collidesUp(6,8,1));
    }

    @Test
    void collidesDown()
    {
        Assertions.assertTrue(map.collidesDown(4,6,3));
        Assertions.assertTrue(map.collidesDown(1,3,8));
        Assertions.assertFalse(map.collidesDown(3,5,10));
        Assertions.assertFalse(map.collidesDown(3,4,7));
    }

    @Test
    void collidesRight()
    {
        Assertions.assertTrue(map.collidesRight(3,3,5));
        Assertions.assertTrue(map.collidesRight(7,0,2));
        Assertions.assertFalse(map.collidesRight(5,8,10));
        Assertions.assertFalse(map.collidesRight(3,5,7));
    }

    private Map movedMapHelper()
    {
        Map movedMap = new Map();
        movedMap.getElements().add(new Element(0,0,2,2,"wall"));
        movedMap.getElements().add(new Element(7,0,1,1,"wall"));
        movedMap.getElements().add(new Element(3,3,4,1,"wall"));
        movedMap.getElements().add(new Element(1,8,2,2,"wall"));
        movedMap.getElements().add(new Element(4,6,3,1,"harmObject"));
        movedMap.getElements().add(new Element(9,8,1,2,"harmObject"));
        movedMap.getElements().add(new Element(10,1,2,1,"harmObject"));
        return movedMap;
    }
    @Property
    void moveMap(@ForAll int offset)
    {
        Map initialMap = movedMapHelper();
        Map movedMap = movedMapHelper();
        movedMap.moveMap(offset);
        for(int i = 0; i < initialMap.getElements().size(); i++)
        {
            Assertions.assertEquals(initialMap.getElements().get(i).getPosition().getX() + offset, movedMap.getElements().get(i).getPosition().getX());
            Assertions.assertEquals(initialMap.getElements().get(i).getPosition().getY(), movedMap.getElements().get(i).getPosition().getY());
        }
    }

    @Test
    void resetPosition()
    {
        Map initialMap = movedMapHelper();

        Map movedMap = movedMapHelper();
        movedMap.resetPosition();
        for(int i = 0; i < initialMap.getElements().size(); i++)
        {
            Assertions.assertEquals(initialMap.getElements().get(i).getPosition().getX()+5400, movedMap.getElements().get(i).getPosition().getX());
            Assertions.assertEquals(initialMap.getElements().get(i).getPosition().getY(), movedMap.getElements().get(i).getPosition().getY());
        }
    }
}
