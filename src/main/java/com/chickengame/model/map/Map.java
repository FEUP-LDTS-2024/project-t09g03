package com.chickengame.model.map;

import com.chickengame.model.elements.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map
{
    private Chicken chicken;
    private Background background;
    private List<HarmObject> harmObjects;
    private List<Wall> walls;


    public Map(String s) throws IOException {
        MapBuilder mapBuilder = new MapBuilder(s);
        mapBuilder.createElements();
        this.chicken = mapBuilder.getChicken();
        this.background = mapBuilder.getBackground();
        this.harmObjects = mapBuilder.getHarmObjects();
        this.walls = mapBuilder.getWalls();
    }

    public Chicken getChicken()
    {
        return this.chicken;
    }

    public void setChicken(Chicken chicken)
    {
        this.chicken = chicken;
    }

    public List<HarmObject> getHarmObjects()
    {
        return this.harmObjects;
    }

    public void setHarmObjects(List<HarmObject> harmObjects)
    {
        this.harmObjects = harmObjects;
    }

    public List<Wall> getWalls()
    {
        return this.walls;
    }

    public void setWalls(List<Wall> walls)
    {
        this.walls = walls;
    }

    public Background getBackground()
    {
        return this.background;
    }

    public void setBackground(Background background)
    {
        this.background = background;
    }
}
