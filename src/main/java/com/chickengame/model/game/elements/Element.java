package com.chickengame.model.game.elements;

import com.chickengame.model.Position;

import java.awt.image.BufferedImage;

public abstract class Element
{
    private Position position;

    public Element(int x, int y)
    {
        this.position = new Position(x,y);
    }
    public Position getPosition()
    {
        return this.position;
    }
    public void setPosition(Position position)
    {
        this.position = position;
    }

}


