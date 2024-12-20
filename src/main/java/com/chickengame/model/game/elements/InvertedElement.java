package com.chickengame.model.game.elements;

public class InvertedElement extends Element
{
    private boolean inverted;

    public InvertedElement(int x, int y,int width, int height, String name, boolean inverted)
    {
        super(x,y,width,height,name);
        this.inverted = inverted;
    }

    public boolean isInverted() {
        return inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }
}
