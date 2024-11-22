package com.chickengame.model.elements;

import com.chickengame.model.Position;

import java.awt.image.BufferedImage;

public class Element
{
    private Position position;
    private final BufferedImage image;

    public Element(int x, int y, BufferedImage image)
    {
        this.position = new Position(x,y);
        this.image = image;
    }
    public Position getPosition()
    {
        return this.position;
    }
    public BufferedImage getImage()
    {
        return this.image;
    }
    void setPosition(Position position)
    {
        this.position = position;
    }
}


