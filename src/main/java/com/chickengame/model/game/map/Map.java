package com.chickengame.model.game.map;

import com.chickengame.model.Position;
import com.chickengame.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    private static final int sizeX = 5400;
    private final List<Element> harmObjects;
    private final List<Element> walls;
    private final List<Element> elements;

    public Map()
    {
        harmObjects = new ArrayList<>();
        walls = new ArrayList<>();
        elements = new ArrayList<>();
    }

    public List<Element> getHarmObjects()
    {
        return harmObjects;
    }

    public List<Element> getWalls()
    {
        return this.walls;
    }

    public int getSizeX()
    {
        return sizeX;
    }

    public Boolean collidesHarmObject(int chickenXMin, int chickenXMax, int chickenYMin, int chickenYMax)
    {
        for (Element harmObject : harmObjects)
        {
            int harmObjectXMin = harmObject.getPosition().getX();
            int harmObjectXMax = harmObjectXMin + harmObject.getWidth();
            int harmObjectYMin = harmObject.getPosition().getY();
            int harmObjectYMax = harmObjectYMin + harmObject.getHeight();

            boolean overlapX = (chickenXMax >= harmObjectXMin && chickenXMin <= harmObjectXMax);
            boolean overlapY = (chickenYMax >= harmObjectYMin && chickenYMin <= harmObjectYMax);

            if (overlapX && overlapY)
            {
                return true;
            }
        }
        return false;
    }


    public boolean collidesUp(int chickenXMin, int chickenXMax, int chickenYMin)
    {
        for (Element wall : walls)
        {
            int wallXMin = wall.getPosition().getX();
            int wallXMax = wallXMin + wall.getWidth();
            int wallYMin = wall.getPosition().getY();
            int wallYMax = wallYMin + wall.getHeight();

            boolean overlapX = (chickenXMax >= wallXMin && chickenXMin <= wallXMax);
            boolean touchingUp = (chickenYMin == wallYMax);

            if (overlapX && touchingUp)
            {
                return true;
            }
        }
        return false;
    }
    public boolean collidesDown(int chickenXMin, int chickenXMax, int chickenYMax)
    {
        for (Element wall : walls)
        {
            int wallXMin = wall.getPosition().getX();
            int wallXMax = wallXMin + wall.getWidth();
            int wallYMin = wall.getPosition().getY();

            boolean overlapX = (chickenXMax >= wallXMin && chickenXMin <= wallXMax);
            boolean touchingUp = (chickenYMax == wallYMin);

            if (overlapX && touchingUp)
            {
                return true;
            }
        }
        return false;
    }

    public boolean collidesRight(int chickenXMax, int chickenYMin, int chickenYMax)
    {
        for (Element wall : walls)
        {
            int wallXMin = wall.getPosition().getX();
            int wallYMin = wall.getPosition().getY();
            int wallYMax = wallYMin + wall.getHeight();

            boolean touchingRight = (chickenXMax == wallXMin);
            boolean overlapY = (chickenYMax > wallYMin && chickenYMin < wallYMax);

            if (touchingRight && overlapY)
            {
                return true;
            }
        }
        return false;
    }

    public void moveMap(int offset)
    {
        for(Element element: elements)
        {
            element.setPosition( new Position(element.getPosition().getX()+offset,element.getPosition().getY()));
        }
    }

    public void resetPosition()
    {
        moveMap(getSizeX());
    }

    public List<Element> getElements()
    {
        return elements;
    }

}
