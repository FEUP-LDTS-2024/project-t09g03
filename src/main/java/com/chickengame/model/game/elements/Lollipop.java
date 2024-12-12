package com.chickengame.model.game.elements;

import java.awt.image.BufferedImage;

public class Lollipop extends Wall
{
    private boolean stateDown;

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
}
