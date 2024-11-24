package com.chickengame.state;

import com.chickengame.model.game.map.Map;
import com.chickengame.model.menu.Menu;

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
