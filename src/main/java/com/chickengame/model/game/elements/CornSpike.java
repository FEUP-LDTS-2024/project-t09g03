package com.chickengame.model.game.elements;

public class CornSpike extends HarmObject{
    private boolean stateDown;

    public CornSpike(int x, int y, boolean stateDown)
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
