package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

public class LevelMap
{
    private final Map map;
    private Chicken chicken;
    private Element finishLine;

    LevelMap(Map map, Chicken chicken, Element finishLine)
    {
        this.map = map;
        this.chicken = chicken;
        this.finishLine = finishLine;
    }
    public Map getMap()
    {
        return map;
    }

    public Chicken getChicken()
    {
        return chicken;
    }

    public Element getFinishLine()
    {
        return finishLine;
    }

}
