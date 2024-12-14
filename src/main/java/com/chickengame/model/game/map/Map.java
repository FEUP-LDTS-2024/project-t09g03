package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    private Chicken chicken;
    private Background background;
    private List<HarmObject> harmObjects;
    private List<Wall> walls;
    private List<Cupcake> cupcakes;
    private List<Lollipop> lollipops;
    private List<Cornspike> cornspikes;
    private List<Platform> platforms;


    public Map()
    {
        harmObjects = new ArrayList<>();
        walls = new ArrayList<>();
        cupcakes = new ArrayList<>();
        lollipops = new ArrayList<>();
        cornspikes = new ArrayList<>();
        platforms = new ArrayList<>();
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

    public List<Wall> getWalls()
    {
        return this.walls;
    }

    public Background getBackground()
    {
        return this.background;
    }

    public void setBackground(Background background)
    {
        this.background = background;
    }

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public List<Lollipop> getLollipops() {
        return lollipops;
    }

    public List<Cornspike> getCornspikes() {
        return cornspikes;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }


    public Boolean colidesHarmObject()
    {
        int chickenXMin = chicken.getPosition().getX();
        int chickenXMax = chickenXMin + chicken.getWIDTH();
        int chickenYMin = chicken.getPosition().getY();
        int chickenYMax = chickenYMin + chicken.getHEIGHT();
        for (HarmObject harmobject : harmObjects)
        {
            int harmObjectXMin = harmobject.getPosition().getX();
            int harmObjectXMax = harmObjectXMin + harmobject.getWIDTH();
            int harmObjectYMin = harmobject.getPosition().getY();
            int harmObjectYMax = harmObjectYMin + harmobject.getHEIGHT();

            boolean overlapX = (chickenXMax >= harmObjectXMin && chickenXMin <= harmObjectXMax);
            boolean overlapY = (chickenYMax >= harmObjectYMin && chickenYMin <= harmObjectYMax);

            if (overlapX && overlapY)
            {
                return true;
            }
        }
        return false;
    }


    public boolean colidesUp()
    {
        int chickenXMin = chicken.getPosition().getX();
        int chickenXMax = chickenXMin + chicken.getWIDTH();
        int chickenYMin = chicken.getPosition().getY();
        int chickenYMax = chickenYMin + chicken.getHEIGHT();

        for (Wall wall : walls)
        {
            int wallXMin = wall.getPosition().getX();
            int wallXMax = wallXMin + wall.getWIDTH();
            int wallYMin = wall.getPosition().getY();
            int wallYMax = wallYMin + wall.getHEIGHT();

            boolean overlapX = (chickenXMax >= wallXMin && chickenXMin <= wallXMax);
            boolean touchingUp = (chickenYMin == wallYMax);

            if (overlapX && touchingUp)
            {
                return true;
            }
        }
        return false;
    }

    public boolean colidesDown()
    {
        int chickenXMin = chicken.getPosition().getX();
        int chickenXMax = chickenXMin + chicken.getWIDTH();
        int chickenYMin = chicken.getPosition().getY();
        int chickenYMax = chickenYMin + chicken.getHEIGHT();

        for (Wall wall : walls)
        {
            int wallXMin = wall.getPosition().getX();
            int wallXMax = wallXMin + wall.getWIDTH();
            int wallYMin = wall.getPosition().getY();
            int wallYMax = wallYMin + wall.getHEIGHT();

            boolean overlapX = (chickenXMax >= wallXMin && chickenXMin <= wallXMax);
            boolean touchingUp = (chickenYMax == wallYMin);

            if (overlapX && touchingUp)
            {
                return true;
            }
        }
        return false;
    }

    public boolean colidesRight()
    {
        int chickenXMin = chicken.getPosition().getX();
        int chickenXMax = chickenXMin + chicken.getWIDTH();
        int chickenYMin = chicken.getPosition().getY();
        int chickenYMax = chickenYMin + chicken.getHEIGHT();

        for (Wall wall : walls)
        {
            int wallXMin = wall.getPosition().getX();
            int wallXMax = wallXMin + wall.getWIDTH();
            int wallYMin = wall.getPosition().getY();
            int wallYMax = wallYMin + wall.getHEIGHT();

            boolean touchingRight = (chickenXMax == wallXMin);
            boolean overlapY = (chickenYMax > wallYMin && chickenYMin < wallYMax);

            if (touchingRight && overlapY)
            {
                return true;
            }
        }
        return false;
    }
}
