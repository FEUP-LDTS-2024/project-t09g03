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

    private List<String> lines;

    public Map createMap(String path, int offset){
        Map map = new Map();
        URL resource = MapBuilder.class.getResource(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(resource.getFile()));
            this.lines = readElements(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        populatemap(map, offset);
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

    public void populatemap(Map map, int offset)
    {
        int maxsize = 0;
        for (String line : this.lines) {
            String[] args;
            args = line.split(" ");
            String element = args[0];
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            boolean stateDown = Boolean.parseBoolean(args[3]);
            switch (element) {
                case "Platform":
                    Platform platform = new Platform(x+offset, y);
                    maxsize = Math.max(maxsize, x + platform.getWIDTH());
                    map.getPlatforms().add(platform);
                    map.getWalls().add(platform);
                    break;
                case "Cornspike":
                    Cornspike cornspike = new Cornspike(x+offset,y,stateDown);
                    maxsize = Math.max(maxsize, x + cornspike.getWIDTH());
                    map.getCornspikes().add(cornspike);
                    map.getHarmObjects().add(cornspike);
                    break;
                case "Cupcake":
                    Cupcake cupcake = new Cupcake(x+offset,y,stateDown);
                    maxsize = Math.max(maxsize, x + cupcake.getWIDTH());
                    map.getCupcakes().add(cupcake);
                    map.getWalls().add(cupcake);
                    break;
                case "Lollipop":
                    Lollipop lollipop = new Lollipop(x+offset,y,stateDown);
                    maxsize = Math.max(maxsize, x + lollipop.getWIDTH());
                    map.getLollipops().add(lollipop);
                    map.getWalls().add(lollipop);
                    break;
                case "CandyCane":
                    CandyCane candyCane = new CandyCane(x+offset,y,stateDown);
                    maxsize = Math.max(maxsize, x + candyCane.getWIDTH());
                    map.getCandyCanes().add(candyCane);
                    map.getWalls().add(candyCane);
                    break;
                case "Gummy":
                    Gummy gummy = new Gummy(x+offset,y,stateDown);
                    maxsize = Math.max(maxsize, x + gummy.getWIDTH());
                    map.getGummies().add(gummy);
                    map.getHarmObjects().add(gummy);
                    break;
                case "IceCream":
                    IceCream iceCream = new IceCream(x,y,stateDown);
                    maxsize = Math.max(maxsize, x + iceCream.getWIDTH());
                    map.getIcecreams().add(iceCream);
                    map.getWalls().add(iceCream);
                    break;
                case "Cookie":
                    Cookie cookie = new Cookie(x,y);
                    maxsize = Math.max(maxsize, x + cookie.getWIDTH());
                    map.getCookies().add(cookie);
                    map.getWalls().add(cookie);
                    break;
                case "Toblerone":
                    Toblerone toblerone = new Toblerone(x,y,stateDown);
                    maxsize = Math.max(maxsize, x + toblerone.getWIDTH());
                    map.getToblerones().add(toblerone);
                    map.getHarmObjects().add(toblerone);
                    break;
                case "ChocolatePlatform":
                    ChocolatePlatform chocolatePlatform = new ChocolatePlatform(x,y);
                    maxsize = Math.max(maxsize, x + chocolatePlatform.getWIDTH());
                    map.getChocolatePlatforms().add(chocolatePlatform);
                    map.getWalls().add(chocolatePlatform);
                    break;
            }
            map.setSizeX(maxsize);
        }
    }

}
