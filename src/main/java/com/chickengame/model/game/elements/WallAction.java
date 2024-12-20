package com.chickengame.model.game.elements;

public class WallAction implements ActionOnTouch{
    @Override
    public Action action() {
        return Action.Colides;
    }
}
