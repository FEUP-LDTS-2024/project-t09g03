package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class LevelMap implements GameMode
{
    private final Map map;
    private Element background;
    private Chicken chicken;
    private Element finishLine;

    LevelMap(Map map, Chicken chicken, Element background, Element finishLine)
    {
        this.map = map;
        this.chicken = chicken;
        this.background = background;
        this.finishLine = finishLine;
    }
    public Map getMap()
    {
        return map;
    }


    public Element getBackground()
    {
        return background;
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
