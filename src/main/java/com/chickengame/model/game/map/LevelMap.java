package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

public class LevelMap {
    private Map map;
    private Element background;
    private Chicken chicken;
    private Element finishLine;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setBackground(Element background) {
        this.background = background;
    }

    public Element getBackground() {
        return background;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public Element getFinishLine() {
        return finishLine;
    }

    public void setFinishLine(Element finishLine) {
        this.finishLine = finishLine;
    }
}
