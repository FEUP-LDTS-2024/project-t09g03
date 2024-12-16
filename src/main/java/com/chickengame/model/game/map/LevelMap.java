package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.FinishLine;

public class LevelMap {
    private Map map;
    private Background background;
    private Chicken chicken;
    private FinishLine finishLine;

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

    public FinishLine getFinishLine() {
        return finishLine;
    }

    public void setFinishLine(FinishLine finishLine) {
        this.finishLine = finishLine;
    }
}
