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
    private List<CandyCane> candyCanes;
    private List<Gummy> gummies;
    private List<IceCream> icecreams;
    private List<Cookie> cookies;
    private List<Toblerone> toblerones;
    private List<ChocolatePlatform> chocolatePlatforms;


    public Map()
    {
        harmObjects = new ArrayList<>();
        walls = new ArrayList<>();
        cupcakes = new ArrayList<>();
        lollipops = new ArrayList<>();
        cornspikes = new ArrayList<>();
        platforms = new ArrayList<>();
        candyCanes = new ArrayList<>();
        gummies = new ArrayList<>();
        cookies = new ArrayList<>();
        toblerones = new ArrayList<>();
        chocolatePlatforms = new ArrayList<>();
        icecreams = new ArrayList<>();
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

    public List<CandyCane> getCandyCanes()
    {
        return candyCanes;
    }

    public void setCandyCanes(List<CandyCane> candyCanes)
    {
        this.candyCanes = candyCanes;
    }

    public List<Gummy> getGummies()
    {
        return gummies;
    }

    public void setGummies(List<Gummy> gummies)
    {
        this.gummies = gummies;
    }

    public List<IceCream> getIcecreams()
    {
        return icecreams;
    }

    public void setIcecreams(List<IceCream> icecreams)
    {
        this.icecreams = icecreams;
    }

    public List<Cookie> getCookies()
    {
        return cookies;
    }

    public void setCookies(List<Cookie> cookies)
    {
        this.cookies = cookies;
    }

    public List<Toblerone> getToblerones()
    {
        return toblerones;
    }

    public void setToblerones(List<Toblerone> toblerones)
    {
        this.toblerones = toblerones;
    }

    public List<ChocolatePlatform> getChocolatePlatforms()
    {
        return chocolatePlatforms;
    }

    public void setChocolatePlatforms(List<ChocolatePlatform> chocolatePlatforms)
    {
        this.chocolatePlatforms = chocolatePlatforms;
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
