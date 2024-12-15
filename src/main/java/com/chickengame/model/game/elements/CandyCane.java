package com.chickengame.model.game.elements;

public class CandyCane extends Wall
{
    private static final int WIDTH = 24;
    private static final int HEIGHT = 47;
    private boolean stateDown;

    public CandyCane(int x, int y, boolean stateDown)
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
