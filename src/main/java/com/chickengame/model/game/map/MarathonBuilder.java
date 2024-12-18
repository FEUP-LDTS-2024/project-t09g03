package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

public class MarathonBuilder {

    public MarathonMap createMarathonMap(int n,String folderPath,MapBuilder mapBuilder, int chickenSkin) {
        MarathonMap marathonMap = new MarathonMap(n);

        int offset = 0;
        marathonMap.setChicken(new Chicken(200,300,"chicken",false,chickenSkin));
        marathonMap.setBackground(new Element(0,0,750,375,"background"));
        for (int i = 1; i <= n; i++){
            String path = folderPath + "Map"+i+".txt";
            Map map = mapBuilder.createMap(path,offset);
            offset = map.getSizeX();
            System.out.println(offset);
            marathonMap.getMaps().add(map);
        }
        return marathonMap;
    }




}
