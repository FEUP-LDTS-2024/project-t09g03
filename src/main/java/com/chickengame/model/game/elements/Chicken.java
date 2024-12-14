package com.chickengame.model.game.elements;

public class Chicken extends Element
{
    private int type;
    private static final int WIDTH = 21;
    private static final int HEIGHT = 28;
    private boolean stateMoving = false;
    private boolean movingDown = true;
    private boolean charge = false;

    public Chicken(int x, int y,int type)
    {
        super(x, y);
        this.type = type;
    }

    public boolean isStateMoving()
    {
        return stateMoving;
    }

    public void setStateMoving(boolean stateMoving)
    {
        this.stateMoving = stateMoving;
    }

    public boolean isMovingDown()
    {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown)
    {
        this.movingDown = movingDown;
    }

    public boolean isCharge()
    {
        return charge;
    }

    public void setCharge(boolean charge)
    {
        this.charge = charge;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
}
