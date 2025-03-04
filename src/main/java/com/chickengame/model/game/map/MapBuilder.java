package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapBuilder
{
    private List<String> lines;

    public Map createMap(String path)
    {
        Map map = new Map();
        URL resource = MapBuilder.class.getClassLoader().getResource(path);
        BufferedReader reader = null;
        try
        {
            if(resource == null)throw (new RuntimeException("Wrong File"));
            reader = new BufferedReader(new FileReader(resource.getFile()));
            lines = readElements(reader);
        }
        catch (IOException | AssertionError e)
        {
            throw new RuntimeException(e);
        }

        populateMap(map);
        return map;
    }

    private List<String> readElements(BufferedReader reader) throws IOException
    {
        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while(line != null)
        {
            lines.add(line);
            line = reader.readLine();
        }
        return lines;
    }

    public void populateMap(Map map)
    {
        int maxsize = 0;
        for (String line : this.lines) {
            String[] args;
            args = line.split(" ");
            String name = args[0];
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            boolean inverted = false;
            Element element = null;
            switch(name)
            {
                case "candyCane":
                    inverted = Boolean.parseBoolean(args[3]);
                    element = new InvertedElement(x ,y,24,47,name,inverted);
                    map.getWalls().add(element);
                    break;
                case "chocolatePlatform", "platform":
                    element = new Element(x,y,40,42,name);
                    map.getWalls().add(element);
                    break;
                case "cookie":
                    element = new Element(x ,y,20,20,name);
                    map.getWalls().add(element);;
                    break;
                case "cornSpike", "toblerone":
                    inverted = Boolean.parseBoolean(args[3]);
                    element = new InvertedElement(x,y,70,15,name,inverted);
                    map.getHarmObjects().add(element);
                    break;
                case "cupcake", "iceCream":
                    inverted = Boolean.parseBoolean(args[3]);
                    element = new InvertedElement(x,y,26,46,name,inverted);
                    map.getWalls().add(element);
                    break;
                case "gummy":
                    inverted = Boolean.parseBoolean(args[3]);
                    element = new InvertedElement(x,y,23,15,name,inverted);
                    map.getHarmObjects().add(element);
                    break;
                case "lollipop":
                    inverted = Boolean.parseBoolean(args[3]);
                    element = new InvertedElement(x,y,24,40,name,inverted);
                    map.getWalls().add(element);
                    break;
            }
            if(element == null)
            {
                throw new RuntimeException();
            }
            map.getElements().add(element);
        }
    }

}
