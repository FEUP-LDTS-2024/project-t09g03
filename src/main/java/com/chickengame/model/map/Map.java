package com.chickengame.model.map;

import com.chickengame.model.elements.Chicken;
import com.chickengame.model.elements.HarmObject;
import com.chickengame.model.elements.Wall;

import java.awt.image.BufferedImage;
import java.util.List;

public class Map
{
    private final int width;
    private final int height;
    private BufferedImage img;

    private Chicken chicken;

    private List<HarmObject> harmObjects;
    private List<Wall> walls;

    public Map(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
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




}
