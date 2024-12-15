package com.chickengame.model.game.elements;

public class Gummy extends HarmObject
{
    private boolean stateDown;
    private static final int WIDTH = 23;
    private static final int HEIGHT = 15;

    public Gummy(int x, int y, boolean stateDown)
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
        return 0;
    }

    @Override
    public int getWIDTH() {
        return 0;
    }
}
