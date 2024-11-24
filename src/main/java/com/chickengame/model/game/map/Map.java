package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.HarmObject;
import com.chickengame.model.game.elements.Wall;

import java.io.IOException;
import java.util.List;

public class Map
{
    private Chicken chicken;
    private Background background;
    private List<HarmObject> harmObjects;
    private List<Wall> walls;


    public Map(String path) throws IOException {
        MapBuilder mapBuilder = new MapBuilder(path);
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
