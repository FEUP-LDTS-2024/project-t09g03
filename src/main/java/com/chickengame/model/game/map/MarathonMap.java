package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarathonMap implements GameMode{

    private final List<Map> maps;
    private Map current;
    private Map nextMap;
    private final Chicken chicken;
    private final Element background;
    private final Random random = new Random();

    MarathonMap(List<Map> mapas, Element background, Chicken chicken)
    {
        this.background = background;
        this.chicken = chicken;
        if(mapas.size()<2)throw new RuntimeException("Not enough maps");
        this.maps = mapas;
        int first = random.nextInt(maps.size());
        current = maps.get(first);
        nextMap = maps.get((first+1)%maps.size());
        nextMap.moveMap(current.getSizeX());
    }

    public void setNextMap()
    {


        current = nextMap;
        while(nextMap == current)
        {
            int next = random.nextInt(maps.size());
            nextMap = maps.get(next);
        }
        nextMap.moveMap(current.getSizeX());
    }

    public Map getCurrent() {
        return current;
    }

    public Map getNextMap() {
        return nextMap;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public Element getBackground() {
        return background;
    }


}
