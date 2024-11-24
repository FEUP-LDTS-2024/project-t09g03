package com.chickengame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest
{
    @Test
    void getUp()
    {
        int x = 15;
        int y = 15;
        assertEquals(new Position(x,y).getUp().getX(),15);
        assertEquals(new Position(x,y).getUp().getY(),14);
    }

    @Test
    void getDown()
    {
        int x = 15;
        int y = 15;
        assertEquals(new Position(x,y).getDown().getX(),15);
        assertEquals(new Position(x,y).getDown().getY(),16);
    }

    @Test
    void getRight()
    {
        int x = 15;
        int y = 15;
        assertEquals(new Position(x,y).getRight().getX(),16);
        assertEquals(new Position(x,y).getRight().getY(),15);
    }

    @Test
    void getLeft()
    {
        int x = 15;
        int y = 15;
        assertEquals(new Position(x,y).getLeft().getX(),14);
        assertEquals(new Position(x,y).getLeft().getY(),15);
    }
}
