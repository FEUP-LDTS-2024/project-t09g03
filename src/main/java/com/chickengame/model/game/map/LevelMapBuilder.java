package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

public class LevelMapBuilder
{

    public LevelMap createLevelMap(String folderPath, MapBuilder mapBuilder, int chickenSkin, int level)
    {
        LevelMap levelMap = new LevelMap();
        levelMap.setChicken(new Chicken(200,300,chickenSkin));
        levelMap.setBackground(new Element(0,0,750,375,"background"));
        levelMap.setFinishLine(new Element(5440,30,40,375,"finishLine"));
        String path = folderPath + "map" + level + ".txt";
        Map map = mapBuilder.createMap(path,0);
        levelMap.setMap(map);
        return levelMap;
    }
}
