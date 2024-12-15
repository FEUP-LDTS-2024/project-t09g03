package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;

public class LevelMap {
    private Map map;
    private Background background;
    private Chicken chicken;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Background getBackground() {
        return background;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }
}
