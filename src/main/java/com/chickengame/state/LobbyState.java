package com.chickengame.state;

import com.chickengame.model.menu.Lobby;

import java.net.URL;
/**Inicializa o Lobby e da-lhe as informacoes que precisam de ser guardadas*/
public class LobbyState {

    public LobbyState()
    {
        URL resource = getClass().getClassLoader().getResource("Menus/Lobby.txt");
    }

}
