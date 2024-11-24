package com.chickengame.state;

import com.chickengame.model.map.Map;
import com.chickengame.model.menu.Lobby;

import java.io.IOException;
import java.net.URL;

public class MarathonState extends State {
    private Map map;
    public MarathonState() throws IOException {
        this.map = new Map("Menus/Lobby.txt");

    }
}