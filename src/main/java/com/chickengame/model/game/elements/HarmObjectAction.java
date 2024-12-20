package com.chickengame.model.game.elements;

public class HarmObjectAction implements ActionOnTouch {
    @Override
    public Action action() {
        return Action.Kills;
    }
}
