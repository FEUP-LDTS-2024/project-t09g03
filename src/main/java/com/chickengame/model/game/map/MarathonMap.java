package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarathonMap{

    private List<Map> maps = new ArrayList<>();
    private int nMaps;
    private int current;
    private int nextMap;
    private Chicken chicken;
    private Background background;

    MarathonMap(int numberofmaps)
    {
        current = 0;
        nextMap = 2;
        this.nMaps = numberofmaps;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setNextMap()
    {
        Random  rand = new Random();
        current = nextMap;
        nextMap = rand.nextInt()%nMaps;
        if(nextMap<0)nextMap = -nextMap;
        while(nextMap == current)
        {
            nextMap = rand.nextInt()%nMaps;
            if(nextMap<0)nextMap = -nextMap;

        }
    }

    public int getCurrent() {
        return current;
    }

    public int getNextMap() {
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
