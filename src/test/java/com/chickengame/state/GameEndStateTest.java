package com.chickengame.state;

import com.chickengame.Game;
import com.chickengame.controller.menus.GameEndController;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.model.menus.Menu;
import com.chickengame.state.menus.GameEndState;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameEndStateTest {
    private GameEndState gameEndState;
    private GameEndMenu menu;
    private GameEndController gameEndController;
    private MenuViewer menuViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.gameEndController = Mockito.mock(GameEndController.class);
        this.menuViewer = Mockito.mock(MenuViewer.class);
        this.menu = Mockito.mock(GameEndMenu.class);
        this.game = Mockito.mock(Game.class);
    }

    @Test
    public void GameEndState() throws IOException {
        this.gameEndState = new GameEndState(menu)
        {
            @Override
            public MenuViewer getStateViewer()
            {
                return menuViewer;
            }
            @Override
            public GameEndController getStateController()
            {
                return gameEndController;
            }
        };

        gameEndState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(gameEndController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(menuViewer, Mockito.times(1)).draw(gui);
    }
}
