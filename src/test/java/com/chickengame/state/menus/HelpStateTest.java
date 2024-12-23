package com.chickengame.state.menus;

import com.chickengame.Game;
import com.chickengame.controller.menus.HelpController;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class HelpStateTest {
    private HelpState helpState;
    private HelpMenu helpMenu;
    private HelpController helpController;
    private MenuViewer menuViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.helpController = Mockito.mock(HelpController.class);
        this.menuViewer = Mockito.mock(MenuViewer.class);
        this.helpMenu = Mockito.mock(HelpMenu.class);
        this.game = Mockito.mock(Game.class);

        Mockito.when(helpMenu.getBackground()).thenReturn("background");
    }

    @Test
    public void helpState() throws IOException {
        this.helpState = new HelpState(helpMenu)
        {
            @Override
            public MenuViewer getStateViewer()
            {
                return menuViewer;
            }
            @Override
            public HelpController getStateController()
            {
                return helpController;
            }
        };

        helpState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(helpController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(menuViewer, Mockito.times(1)).draw(gui);
    }

    @Test
    public void helpStateCreate()
    {
        HelpState helpState = new HelpState(helpMenu);

        assert helpState.getStateController() != null;
        assert helpState.getStateViewer() != null;
    }
}
