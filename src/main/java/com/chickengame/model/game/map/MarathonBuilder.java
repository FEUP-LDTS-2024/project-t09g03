package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;

public class MarathonBuilder
{
    public MarathonMap createMarathonMap(int n,String folderPath,MapBuilder mapBuilder, int chickenSkin)
    {
        ArrayList<Map> mapList = new ArrayList<Map>();

        for (int i = 1; i <= n; i++)
        {
            String path = folderPath + "map"+i+".txt";
            Map map = mapBuilder.createMap(path,0);
            mapList.add(map);
        }
        Element background = new Element(0,0,750,375,"background");
        Chicken chicken = new Chicken(300,300,chickenSkin);

        return new MarathonMap(mapList, background, chicken);
    }




}
