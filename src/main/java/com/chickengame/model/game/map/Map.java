package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.*;

import java.io.IOException;
import java.util.List;
/**classe Map chama classe MapBuilder para ser instanciado, passando o caminho da localizacao que deve ser mostrada na tela*/
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


    public Map() {}

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

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public void setCupcakes(List<Cupcake> cupcakes) {
        this.cupcakes = cupcakes;
    }

    public List<Lollipop> getLollipops() {
        return lollipops;
    }

    public void setLollipops(List<Lollipop> lollipops) {
        this.lollipops = lollipops;
    }

    public List<Cornspike> getCornspikes() {
        return cornspikes;
    }

    public void setCornspikes(List<Cornspike> cornspikes) {
        this.cornspikes = cornspikes;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
/*
    public boolean colides(int x1, int y1, int x2, int y2)
    {
        for(Wall w : getWalls())
        {
            if(w.getPosition().getX() + w.getWIDTH()>x1 && w.getPosition().getX()<x1 || w.getPosition().getX() + w.getWIDTH()>x1 && w.getPosition().getX()<x1 & )
        }
    }
*/


    public void colidesup()
    {

    }
}
