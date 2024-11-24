package com.chickengame.state;

import com.chickengame.model.game.map.Map;

import java.io.IOException;

public abstract class State {
    protected String path;
    State(String path) throws IOException
    {
        this.path = path;
    }
    public Map getMap()
    {
        return null;
    }

}
