package com.chickengame.model.game.elements;

public class IceCream extends Wall
{
    private static final int WIDTH = 26;
    private static final int HEIGHT = 46;
    private boolean stateDown;

    public IceCream(int x, int y, boolean stateDown)
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
    public int getHEIGHT()
    {
        return HEIGHT;
    }

    @Override
    public int getWIDTH()
    {
        return WIDTH;
    }
}
