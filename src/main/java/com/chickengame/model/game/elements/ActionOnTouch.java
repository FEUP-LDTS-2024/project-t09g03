package com.chickengame.model.game.elements;

public interface ActionOnTouch {
    enum Action{Colides, Kills, Collects, None}
    ActionOnTouch.Action action();
}
