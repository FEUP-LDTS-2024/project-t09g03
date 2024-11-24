package com.chickengame.state;

import com.chickengame.model.map.Map;
import com.chickengame.model.menu.Lobby;

import java.io.IOException;
import java.net.URL;

public class MarathonState {
    private Map map;
    public MarathonState(String s) throws IOException {
        this.map = new Map(s);
    }
    public Map getMap()
    {
        return this.map;
    }
}