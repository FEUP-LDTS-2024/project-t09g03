package com.chickengame.model.game.elements;

public class Platform extends Wall
{
    private static final int WIDTH = 40;
    private static final int HEIGHT = 42;
    private int state;
    public Platform(int x, int y)
    {
        super(x, y);
    }

    @Override
    public int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public int getWIDTH() {
        return WIDTH;
    }


}
