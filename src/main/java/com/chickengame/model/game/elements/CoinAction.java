package com.chickengame.model.game.elements;

public class CoinAction implements ActionOnTouch {
    @Override
    public Action action() {
        return Action.Collects;
    }
}
