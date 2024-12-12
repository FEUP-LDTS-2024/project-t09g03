package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapBuilder{

    private List<String> elements;
    private Chicken chicken;
    private Background background;
    private List<Wall> walls = new ArrayList<Wall>();
    private List<HarmObject> harmObjects = new ArrayList<HarmObject>();
    private List<Cupcake> cupcakes = new ArrayList<Cupcake>();
    private List<Lollipop> lollipops = new ArrayList<Lollipop>();
    private List<Cornspike> cornspikes =  new ArrayList<Cornspike>();
    private List<Platform> platforms = new ArrayList<Platform>();

    public Map createMap(String path) throws IOException {
        Map map = new Map();

        URL resource = MapBuilder.class.getResource(path);
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        this.elements = readElements(reader);
        createElements();
        map.setChicken(chicken);
        map.setBackground(background);
        map.setWalls(walls);
        map.setHarmObjects(harmObjects);
        map.setCornspikes(cornspikes);
        map.setCupcakes(cupcakes);
        map.setLollipops(lollipops);
        map.setPlatforms(platforms);

        return map;
    }
    public MapBuilder() throws IOException {
    }

    private List<String> readElements(BufferedReader reader) throws IOException
    {
        List<String> elements = new ArrayList<>();
        String element = reader.readLine();
        while(element != null)
        {
            elements.add(element);
            element = reader.readLine();
        }
        return elements;
    }

    public void createElements()
    {
        this.walls = new ArrayList<>();
        this.harmObjects = new ArrayList<>();

        for (String element : this.elements) {
            String[] args;
            args = element.split(" ");
            String c = args[0];
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            boolean stateDown = Boolean.parseBoolean(args[3]);
            switch (c) {
                case "Chicken":
                    this.chicken = new Chicken(x, y);
                    break;
                case "Platform":
                    Platform platform = new Platform(x, y);
                    this.platforms.add(platform);
                    this.walls.add(platform);
                    break;
                case "Cornspike":
                    Cornspike cornspike = new Cornspike(x,y,stateDown);
                    this.cornspikes.add(cornspike);
                    this.harmObjects.add(cornspike);
                    break;
                case "Cupcake":
                    Cupcake cupcake = new Cupcake(x, y,stateDown);
                    this.cupcakes.add(cupcake);
                    this.walls.add(cupcake);
                    break;
                case "Lollipop":
                    Lollipop lollipop = new Lollipop(x, y,stateDown);
                    this.lollipops.add(lollipop);
                    this.walls.add(lollipop);
                    break;
                default:
                    this.background = new Background(x, y);
            }
        }
    }
    public Chicken getChicken()
    {
        return this.chicken;
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

    public List<Cupcake> getCupcakes()
    {
        return cupcakes;
    }

    public void setCupcakes(List<Cupcake> cupcakes)
    {
        this.cupcakes = cupcakes;
    }

    public List<Lollipop> getLollipops()
    {
        return lollipops;
    }

    public void setLollipops(List<Lollipop> lollipops)
    {
        this.lollipops = lollipops;
    }

    public List<Cornspike> getCornspikes()
    {
        return cornspikes;
    }

    public void setCornspikes(List<Cornspike> cornspikes)
    {
        this.cornspikes = cornspikes;
    }

    public List<Platform> getPlatforms()
    {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms)
    {
        this.platforms = platforms;
    }
}
