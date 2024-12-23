package com.chickengame.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest
{
    @Test
    void testGetters()
    {
        Position position1 = new Position(0, 0);
        Position position2 = new Position(10, 20);
        position1.setX(5);
        position1.setY(10);
        assertEquals(position1.getX(),5);
        assertEquals(position1.getY(),10);

        assertEquals(position2.getX(),10);
        assertEquals(position2.getY(),20);
    }
}
