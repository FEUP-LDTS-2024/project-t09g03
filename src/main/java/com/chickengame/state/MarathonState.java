package com.chickengame.state;

import com.chickengame.model.game.map.Map;

import java.io.IOException;

public class MarathonState extends State {
    private Map map;
    public MarathonState(String path) throws IOException
    {
        super(path);
        this.map = new Map(path);
    }

    @Override
    public Map getMap()
    {
        return this.map;
    }
}