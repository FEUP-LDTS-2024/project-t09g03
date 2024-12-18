package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;

import java.util.List;
import java.util.Random;

public class MarathonMap{

    private List<Map> maps;
    private int nMaps;
    private Map current;
    private Map nextMap;
    private Chicken chicken;
    private Background background;

    MarathonMap(int numberofmaps, List<Map> mapas)
    {
        this.maps = mapas;
        current = mapas.getFirst();
        nextMap = mapas.getLast();
        this.nMaps = numberofmaps;
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
            int next = rand.nextInt()%nMaps;
            if(next<0)next = -next;
            nextMap = maps.get(next);
        }
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

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

}
