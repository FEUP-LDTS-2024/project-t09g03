package com.chickengame.state.menus;

import com.chickengame.Game;
import com.chickengame.controller.menus.GameEndController;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.state.game.MarathonState;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class GameEndStateTest {
    private GameEndState gameEndState;
    private GameEndMenu gameEndMenu;
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
        this.gameEndMenu = Mockito.mock(GameEndMenu.class);
        this.game = Mockito.mock(Game.class);

        Mockito.when(gameEndMenu.getBackground()).thenReturn("backgroudn");
    }

    @Test
    public void gameEndState() throws IOException {
        this.gameEndState = new GameEndState(gameEndMenu)
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

    @Test
    public void gameEndStateCreate()
    {
        GameEndState gameEndState = new GameEndState(gameEndMenu);


        Assertions.assertNotNull(gameEndState.getStateController());
        Assertions.assertNotNull(gameEndState.getStateController());
    }
}
