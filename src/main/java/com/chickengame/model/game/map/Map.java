package com.chickengame.model.game.map;

import com.chickengame.model.Position;
import com.chickengame.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    private int sizeX;
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

    public List<HarmObject> getHarmObjects()
    {
        return this.harmObjects;
    }

    public List<Wall> getWalls()
    {
        return this.walls;
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

    public List<Gummy> getGummies()
    {
        return gummies;
    }

    public List<IceCream> getIcecreams()
    {
        return icecreams;
    }

    public List<Cookie> getCookies()
    {
        return cookies;
    }

    public List<Toblerone> getToblerones()
    {
        return toblerones;
    }

    public List<ChocolatePlatform> getChocolatePlatforms()
    {
        return chocolatePlatforms;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public Boolean colidesHarmObject(Chicken chicken)
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


    public boolean colidesUp(Chicken chicken)
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
    public boolean colidesDown(Chicken chicken)
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

    public boolean colidesRight(Chicken chicken)
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


    public void moveMap(int offset)
    {
        moveWalls(offset);
        moveHarmObjects(offset);
    }

    public void resetMapposition()
    {
        moveMap(getSizeX()*2);
    }


    private void moveHarmObjects(int offset)
    {
        for(HarmObject H: harmObjects)
        {
            H.setPosition( new Position(H.getPosition().getX()+offset,H.getPosition().getY()));
        }
    }

    private void moveWalls(int offset)
    {
        for(Wall w: this.walls) {
            w.setPosition(new Position(w.getPosition().getX() + offset, w.getPosition().getY()));
        }
    }

}
