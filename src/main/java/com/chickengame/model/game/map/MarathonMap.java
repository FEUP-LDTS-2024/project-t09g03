package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;

import java.util.List;
import java.util.Random;

public class MarathonMap
{

    private final List<Map> maps;
    private Map current;
    private Map nextMap;
    private final Chicken chicken;
    private final Random random = new Random();

    public MarathonMap(List<Map> maps, Chicken chicken)
    {
        this.chicken = chicken;
        if(maps.size()<2)throw new RuntimeException("Not enough maps");
        int first = random.nextInt(maps.size());
        current = maps.get(first);
        nextMap = maps.get((first+1)%maps.size());
        nextMap.moveMap(current.getSizeX());
        this.maps = maps;
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

}
