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

        assertEquals(position1.getX(),0);
        assertEquals(position1.getY(),0);

        assertEquals(position2.getX(),10);
        assertEquals(position2.getY(),20);
    }
}
