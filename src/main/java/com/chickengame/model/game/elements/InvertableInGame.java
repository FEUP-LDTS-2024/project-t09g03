package com.chickengame.model.game.elements;

public class InvertableInGame implements Inverts{

    private final boolean inverted;
    InvertableInGame(boolean isInverted)
    {
        this.inverted = isInverted;
    }

    @Override
    public boolean isInvertable() {
        return true;
    }

    @Override
    public boolean isInverted() {
        return inverted;
    }

    @Override
    public void invert(){
        return;
    }
}
