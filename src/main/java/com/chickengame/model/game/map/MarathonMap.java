package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

import java.util.List;
import java.util.Random;

public class MarathonMap{

    private final List<Map> maps;
    private Map current;
    private Map nextMap;
    private Chicken chicken;
    private Element background;
    private Random random = new Random();

    MarathonMap(List<Map> maps)
    {
        if(maps.size()<2)
        {
            throw new RuntimeException("Not enough maps");
        }
        int first = random.nextInt(maps.size());
        current = maps.get(first);
        nextMap = maps.get((first+1) % maps.size());
        nextMap.moveMap(current.getSizeX());
        this.maps = maps;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setNextMap()
    {
        Random  rand = new Random();

        current = nextMap;
        while(nextMap == current)
        {
            int next = rand.nextInt(maps.size());
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

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public Element getBackground() {
        return background;
    }

    public void setBackground(Element background) {
        this.background = background;
    }

}
