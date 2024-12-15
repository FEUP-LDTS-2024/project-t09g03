package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class LevelMapBuilder {

    public LevelMap createLevelMap(String folderPath,MapBuilder mapBuilder ,int chickenSkin, int level)
    {
        LevelMap levelmap = new LevelMap();
        try {
            getSingleElements(folderPath + "startlevel.txt",levelmap,chickenSkin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String path = folderPath + "Map" + level +".txt";
        Map map = mapBuilder.createMap(path,0);
        levelmap.setMap(map);
        return levelmap;
    }
    private void getSingleElements(String path, LevelMap map, int chickenType) throws IOException {
        URL resource = LevelMap.class.getResource(path);
        BufferedReader reader = null;
        if(resource == null) {
            throw new IOException("Invalid FilePath");
        }
        reader  = new BufferedReader(new FileReader(resource.getFile()));
        String line = reader.readLine() ;
        while (line != null)
        {
            String[] args;
            args = line.split(" ");
            String element = args[0];
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            switch (element)
            {
                case "Chicken"->map.setChicken(new Chicken(x,y,chickenType));
                case "Background"-> map.setBackground(new Background(x,y));
            }
            line = reader.readLine();
        }
    }
}
