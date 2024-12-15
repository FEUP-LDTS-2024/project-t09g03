package com.chickengame.model.game.elements;

public class Cookie extends Wall
{
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    public Cookie(int x, int y, boolean stateDown)
    {
        super(x, y);
    }

    @Override
    public int getHEIGHT()
    {
        return 0;
    }

    @Override
    public int getWIDTH()
    {
        return 0;
    }
}
