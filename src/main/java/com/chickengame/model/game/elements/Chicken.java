package com.chickengame.model.game.elements;

public class Chicken extends Element
{
    private static final int WIDTH = 21;
    private static final int HEIGHT = 28;
    private boolean movingLeft = false;
    private boolean stateMoving = false;
    private boolean movingDown = true;
    private boolean charge = false;

    public Chicken(int x, int y)
    {
        super(x, y);
    }

    public boolean isMovingLeft()
    {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft)
    {
        this.movingLeft = movingLeft;
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
}
