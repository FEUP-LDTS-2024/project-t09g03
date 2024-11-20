package com.chickengame.model;

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
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public BufferedImage getImage()
    {
        return this.image;
    }
}


