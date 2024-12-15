package com.chickengame.model.game.elements;

public class Toblerone extends HarmObject
{
    private boolean stateDown;
    private static final int WIDTH = 70;
    private static final int HEIGHT = 15;

    public Toblerone(int x, int y, boolean stateDown)
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
