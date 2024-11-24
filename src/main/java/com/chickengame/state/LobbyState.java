package com.chickengame.state;

import com.chickengame.model.menu.Lobby;

import java.net.URL;
/**Inicializa o Lobby e da-lhe as informacoes que precisam de ser guardadas*/
public class LobbyState extends GameState{

    private final Lobby lobby;
    public LobbyState()
    {
        URL resource = getClass().getClassLoader().getResource("Menus/Lobby.txt");
        lobby = new Lobby("Menus/Lobby.txt");
    }

    @Override
    public Lobby getMenu() {
        return lobby;
    }
}
