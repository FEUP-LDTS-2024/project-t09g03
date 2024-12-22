package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

public interface GameMode {
    Chicken getChicken();
    Element getBackground();
}
