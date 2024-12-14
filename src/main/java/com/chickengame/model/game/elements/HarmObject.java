package com.chickengame.model.game.elements;


public abstract class HarmObject extends Element
{
    public HarmObject(int x, int y)
    {
        super(x, y);
    }

    public abstract int getHEIGHT();

    public abstract int getWIDTH();
}
