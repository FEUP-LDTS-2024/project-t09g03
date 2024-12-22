package com.chickengame.state;

import com.chickengame.Game;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MainMenuStateTest {
    private MainMenuState mainMenuState;
    private Menu menu;
    private MainMenuController mainMenuController;
    private MenuViewer menuViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.mainMenuController = Mockito.mock(MainMenuController.class);
        this.menuViewer = Mockito.mock(MenuViewer.class);
        this.menu = Mockito.mock(Menu.class);
        this.game = Mockito.mock(Game.class);
    }

    @Test
    public void mainMenuState() throws IOException {
        this.mainMenuState = new MainMenuState(menu)
        {
          @Override
          public MenuViewer getStateViewer()
          {
            return menuViewer;
          }
          @Override
            public MainMenuController getStateController()
          {
              return mainMenuController;
          }
        };

        mainMenuState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(mainMenuController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(menuViewer, Mockito.times(1)).draw(gui);
    }
}