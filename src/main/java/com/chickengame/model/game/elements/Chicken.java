package com.chickengame.model.game.elements;

public class Chicken extends InvertedElement
{
    private final int skin;
    private boolean walking = false;
    private boolean charge = false;

    public Chicken(int x, int y, int skin)
    {
        super(x,y,21,28,"chicken",false);
        this.skin = skin;
    }

    public boolean isWalking()
    {
        return walking;
    }

    public void setWalking(boolean walking)
    {
        this.walking = walking;
    }

    public boolean isCharge()
    {
        return charge;
    }

    public void setCharge(boolean charge)
    {
        this.charge = charge;
    }

    public int getSkin()
    {
        return skin;
    }
}
