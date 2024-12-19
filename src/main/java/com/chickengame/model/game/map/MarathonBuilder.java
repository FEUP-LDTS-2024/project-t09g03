package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;

public class MarathonBuilder {

    public MarathonMap createMarathonMap(int n,String folderPath,MapBuilder mapBuilder, int chickenSkin) {
        ArrayList<Map> mapList = new ArrayList<Map>();
        for (int i = 1; i <= n; i++){
            String path = folderPath + "Map"+i+".txt";
            Map map = mapBuilder.createMap(path,0);
            mapList.add(map);
        }
        MarathonMap marathonMap = new MarathonMap(mapList);
        marathonMap.setChicken(new Chicken(200,300,"chicken",false,chickenSkin));
        marathonMap.setBackground(new Element(0,0,750,375,"background"));
        return marathonMap;
    }




}
