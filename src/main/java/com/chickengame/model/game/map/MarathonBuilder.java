package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MarathonBuilder {

    public MarathonMap createMarathonMap(int n,String folderPath,MapBuilder mapBuilder, int ChickenSkin) {
        ArrayList<Map> mapList = new ArrayList<Map>();
        MarathonMap marathonMap = new MarathonMap(n, mapList);
        int offset = 0;
        try {
            getSingleElements(folderPath + "marathon.txt",marathonMap,ChickenSkin);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i <= n; i++){
            String path = folderPath + "Map"+i+".txt";
            Map map = mapBuilder.createMap(path,offset);
            offset = map.getSizeX();
            marathonMap.getMaps().add(map);
        }
        return marathonMap;
    }

    private void getSingleElements(String path, MarathonMap map, int chickenType) throws IOException {
        URL resource = MarathonMap.class.getResource(path);
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
