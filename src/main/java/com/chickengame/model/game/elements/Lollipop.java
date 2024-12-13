package com.chickengame.model.game.elements;

import java.awt.image.BufferedImage;

public class Lollipop extends Wall
{
    private boolean stateDown;
    private static final int WIDTH = 24;
    private static final int HEIGHT = 47;
    public Lollipop(int x, int y, boolean stateDown)
    {
        super(x, y);
        this.stateDown = stateDown;
    }

    public boolean getStateDown()
    {
        return this.stateDown;
    }

    public void setStateDown(boolean stateDown)
    {
        this.stateDown = stateDown;
    }


    @Override
    public int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public int getWIDTH() {
        return WIDTH;
    }
}
