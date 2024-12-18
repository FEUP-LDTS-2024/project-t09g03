package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LevelMapBuilder {

    public LevelMap createLevelMap(String folderPath,MapBuilder mapBuilder ,int chickenSkin, int level)
    {
        LevelMap levelmap = new LevelMap();
        getSingleElements(levelmap,chickenSkin);
        String path = folderPath + "Map" + level +".txt";
        Map map = mapBuilder.createMap(path,0);
        levelmap.setMap(map);
        return levelmap;
    }
    private void getSingleElements(LevelMap levelMap, int chickenType)
    {
        levelMap.setChicken(new Chicken(200,300,"chicken",false,chickenType));
        levelMap.setBackground(new Element(0,0,750,375,"background"));
        levelMap.setFinishLine(new Element(5440,30,40,375,"finishLine"));
    }
}
