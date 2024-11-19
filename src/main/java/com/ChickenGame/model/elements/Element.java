package com.ChickenGame.model.elements;

import java.awt.image.BufferedImage;

public class Element {
    private int x;
    private int y;
    private final BufferedImage image;

    Element(int x, int y, BufferedImage image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
    }
    int getX()
    {
        return this.x;
    }
    int getY()
    {
        return this.y;
    }
    BufferedImage getImage()
    {
        return this.image;
    }
    void setX(int x)
    {
        this.x = x;
    }
    void setY(int y)
    {
        this.y = y;
    }
}


