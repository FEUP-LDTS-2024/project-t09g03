package com.chickengame.model.game.elements;

public class Cornspike extends HarmObject{
    private boolean stateDown;
    private static final int WIDTH = 90;
    private static final int HEIGHT = 15;

    public Cornspike(int x, int y, boolean stateDown)
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

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
