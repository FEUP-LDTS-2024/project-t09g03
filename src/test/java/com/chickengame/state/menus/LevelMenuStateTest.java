package com.chickengame.state.menus;

import com.chickengame.Game;
import com.chickengame.controller.menus.LevelMenuController;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LevelMenuStateTest {
    private LevelMenuState levelMenuState;
    private LevelMenu levelMenu;
    private LevelMenuController levelMenuController;
    private MenuViewer menuViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.levelMenuController = Mockito.mock(LevelMenuController.class);
        this.menuViewer = Mockito.mock(MenuViewer.class);
        this.levelMenu = Mockito.mock(LevelMenu.class);
        this.game = Mockito.mock(Game.class);

        Mockito.when(levelMenu.getBackground()).thenReturn("background");
    }

    @Test
    public void levelMenuState() throws IOException {
        this.levelMenuState = new LevelMenuState(levelMenu)
        {
            @Override
            public MenuViewer getStateViewer()
            {
                return menuViewer;
            }
            @Override
            public LevelMenuController getStateController()
            {
                return levelMenuController;
            }
        };

        levelMenuState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(levelMenuController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(menuViewer, Mockito.times(1)).draw(gui);
    }

    @Test
    public void levelMenuStateCreate()
    {
        LevelMenuState levelMenuState = new LevelMenuState(levelMenu);

        assert levelMenuState.getStateController() != null;
        assert levelMenuState.getStateViewer() != null;
    }
}
