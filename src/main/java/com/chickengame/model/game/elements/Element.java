package com.chickengame.model.game.elements;

import com.chickengame.model.Position;

public class Element
{
    private Position position;

    private final String name;

    private final int width;
    private final int height;


    public Element(int x, int y, int width, int height,String name)
    {
        this.position = new Position(x,y);
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public String getName()
    {
        return name;
    }
}


