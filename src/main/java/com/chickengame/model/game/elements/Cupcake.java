package com.chickengame.model.game.elements;

import java.awt.image.BufferedImage;

public class Cupcake extends Wall
{
    private boolean stateDown;

    public Cupcake(int x, int y, boolean stateDown)
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
}
