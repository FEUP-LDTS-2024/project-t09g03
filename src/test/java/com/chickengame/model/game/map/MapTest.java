package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Element;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MapTest
{
    private Map map;

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
        assert(map.collidesHarmObject(4,6,7,9));
        assert(map.collidesHarmObject(8,10,7,9));
        assertFalse(map.collidesHarmObject(4,6,9,11));
        assertFalse(map.collidesHarmObject(7,9,2,4));
    }

    @Test
    void collidesUp()
    {
        assertFalse(map.collidesUp(0,2,3));
        assertFalse(map.collidesUp(2,4,0));

        assert(map.collidesUp(0,2,2));
        assert(map.collidesUp(6,8,1));
    }

    @Test
    void collidesDown()
    {
        assert(map.collidesDown(4,6,3));
        assert(map.collidesDown(1,3,8));
        assertFalse(map.collidesDown(3,5,10));
        assertFalse(map.collidesDown(3,5,10));
    }

    @Test
    void collidesRight()
    {
        assert(map.collidesRight(3,3,5));
        assert(map.collidesRight(7,0,2));
        assertFalse(map.collidesRight(5,8,10));
        assertFalse(map.collidesRight(3,5,7));
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
            assertEquals(initialMap.getElements().get(i).getPosition().getX() + offset, movedMap.getElements().get(i).getPosition().getX());
            assertEquals(initialMap.getElements().get(i).getPosition().getY(),movedMap.getElements().get(i).getPosition().getY());
        }
    }

    @Property
    void resetPosition(@ForAll int sizeX)
    {
        Map initialMap = movedMapHelper();
        initialMap.setSizeX(sizeX);
        Map movedMap = movedMapHelper();
        movedMap.setSizeX(sizeX);
        movedMap.resetPosition();
        for(int i = 0; i < initialMap.getElements().size(); i++)
        {
            assertEquals(initialMap.getElements().get(i).getPosition().getX() + 2*sizeX, movedMap.getElements().get(i).getPosition().getX());
            assertEquals(initialMap.getElements().get(i).getPosition().getY(),movedMap.getElements().get(i).getPosition().getY());
        }
    }
}
