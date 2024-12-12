package com.chickengame.model.game.elements;

import java.awt.image.BufferedImage;

public class Chicken extends Element
{
    private boolean movingLeft = false;
    private boolean stateMoving = true;
    private boolean stateDown = true;
    private boolean movingDown = true;
    private boolean charge = true;

    public Chicken(int x, int y)
    {
        super(x, y);
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isStateMoving() {
        return stateMoving;
    }

    public void setStateMoving(boolean stateMoving) {
        this.stateMoving = stateMoving;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public boolean isStateDown() {
        return stateDown;
    }

    public void setStateDown(boolean stateDown) {
        this.stateDown = stateDown;
    }
}
