package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;

public class LevelMapBuilder
{

    public LevelMap createLevelMap(String folderPath, MapBuilder mapBuilder, int chickenSkin, int level)
    {
        String path = folderPath + "map" + level + ".txt";
        Map map = mapBuilder.createMap(path);
        Chicken chicken = new Chicken(200,300,chickenSkin);
        Element FinishLine = new Element(5440,30,40,375,"finishLine");
        return new LevelMap(map,chicken,FinishLine);
    }
}
