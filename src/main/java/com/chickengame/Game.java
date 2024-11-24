package com.chickengame;


import com.chickengame.gui.LanternaDraw;
import com.chickengame.state.State;
import com.chickengame.state.LobbyState;
import com.chickengame.viewer.MenuViewer;

import java.io.IOException;

/** principio singleton: apenas uma instancia da classe*/
public class Game {

    private static Game instance;
    private final LanternaDraw lanternaDraw;
    private State gameState;

    /**cria uma nova instancia se ela ainda não existir, caso contrario retorna a existente*/
    public static Game getInstance()
    {
        if(instance == null)
        {
            instance =  new Game();
        }
        return instance;
    }
    /**construtor privado de forma a que seja instanciado apenas uma vez
     * lanternDraw: desenho grafico do jogo
     * gameState: o primeiro estado do jogo é inicializado no Lobby*/
    private Game()
    {
        this.lanternaDraw = new LanternaDraw();
        this.gameState = new LobbyState();
    }
    /** cria uma instancia de MenuViewer com os graficos e o Lobby
     * desenha o gameState na tela
     * atualiza continuamente o lanterna*/
    public void run()
    {
        MenuViewer viewer = new MenuViewer(lanternaDraw, gameState.getMenu());
        while (gameState != null)
        {
            try
            {
                viewer.drawMenu();
                lanternaDraw.getScreen().refresh();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    /**altera o estado atual do jogo*/
    public void setGameState(State state)
    {
        this.gameState = state;
    }

}