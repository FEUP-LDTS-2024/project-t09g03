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

    public Map createMap(String path){
        Map map = new Map();
        URL resource = MapBuilder.class.getResource(path);
        if(resource == null) {
            System.out.println("hello");
          return map;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(resource.getFile()));
            this.elements = readElements(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        populatemap(map);
        return map;
    }
    public MapBuilder(){
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

    public void populatemap(Map map)
    {
        for (String element : this.elements) {
            String[] args;
            args = element.split(" ");
            String c = args[0];
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            boolean stateDown = Boolean.parseBoolean(args[3]);
            switch (c) {
                case "Chicken":
                    map.setChicken(new Chicken(x, y));
                    break;
                case "Platform":
                    Platform platform = new Platform(x, y);
                    map.getPlatforms().add(platform);
                    map.getWalls().add(platform);
                    break;
                case "Cornspike":
                    Cornspike cornspike = new Cornspike(x,y,stateDown);
                    map.getCornspikes().add(cornspike);
                    map.getHarmObjects().add(cornspike);
                    break;
                case "Cupcake":
                    Cupcake cupcake = new Cupcake(x,y,stateDown);
                    map.getCupcakes().add(cupcake);
                    map.getWalls().add(cupcake);
                    break;
                case "Lollipop":
                    Lollipop lollipop = new Lollipop(x,y,stateDown);
                    map.getLollipops().add(lollipop);
                    map.getWalls().add(lollipop);
                    break;
                default:
                    map.setBackground(new Background(x, y));
            }
        }
    }

}
