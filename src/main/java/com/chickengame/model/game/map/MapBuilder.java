package com.chickengame.model.map;

import com.chickengame.controler.ImageHandler;
import com.chickengame.model.elements.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapBuilder{

    private final List<String> elements;
    private Chicken chicken;
    private Background background;
    private List<Wall> walls;
    private List<HarmObject> harmObjects;

    public MapBuilder(String s) throws IOException {
        URL resource = MapBuilder.class.getResource("/Menus/Game.txt");
        if(resource == null)
        {
            System.out.println("erro de resource!!");
        }
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));

        this.elements = readElements(reader);
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
            BufferedImage img;
            try {
                img = ImageHandler.getImage(args[3]);
            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
            switch (c) {
                case "C":
                    this.chicken = new Chicken(x, y, img);
                    break;
                case "W":
                    this.walls.add(new Wall(x, y, img));
                    break;
                case "H":
                    this.harmObjects.add(new HarmObject(x, y, img));
                    break;
                default:
                    this.background = new Background(x, y, img);
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
}
