package com.chickengame.state;

import com.chickengame.Game;
import com.chickengame.controller.game.LevelController;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.map.LevelViewer;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LevelStateTest {
    private LevelState levelState;
    private LevelMap levelMap;
    private LevelController levelController;
    private LevelViewer levelViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.levelController = Mockito.mock(LevelController.class);
        this.levelViewer = Mockito.mock(LevelViewer.class);
        this.levelMap = Mockito.mock(LevelMap.class);
        this.game = Mockito.mock(Game.class);
    }

    @Test
    public void mainMenuState() throws IOException {
        this.levelState = new LevelState(levelMap)
        {
            @Override
            public LevelViewer getStateViewer()
            {
                return levelViewer;
            }
            @Override
            public LevelController getStateController()
            {
                return levelController;
            }
        };

        levelState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(levelController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(levelViewer, Mockito.times(1)).draw(gui);
    }
}
