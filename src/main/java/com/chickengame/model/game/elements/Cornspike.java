package com.chickengame.model.game.elements;

public class Cornspike extends HarmObject{
    private boolean stateDown;

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
}
