package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarathonMap{

    private List<Map> maps;
    private Map current;
    private Map nextMap;
    private Chicken chicken;
    private Element background;
    private Random random = new Random();

    MarathonMap(List<Map> mapas)
    {
        if(mapas.size()<2)throw new RuntimeException("Not enough maps");
        this.maps = mapas;
        int first = random.nextInt(mapas.size());
        current = mapas.get(first);
        nextMap = mapas.get((first+1)%mapas.size());
        nextMap.moveMap(current.getSizeX());
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
