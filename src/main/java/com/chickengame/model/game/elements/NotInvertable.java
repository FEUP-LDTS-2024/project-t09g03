package com.chickengame.model.game.elements;

public class NotInvertable implements Inverts{
    @Override
    public boolean isInvertable() {
        return false;
    }

    @Override
    public boolean isInverted() {
        return false;
    }

    @Override
    public void invert() {
        return;
    }
}
