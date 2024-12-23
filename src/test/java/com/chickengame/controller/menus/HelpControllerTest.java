package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.HelpMenu;
import com.chickengame.state.menus.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class HelpControllerTest {
    private Game game;
    private GUI gui;
    private HelpController helpController;
    private HelpMenu helpMenu;

    @BeforeEach
    public void helper() {
        this.helpMenu = Mockito.mock(HelpMenu.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);

        this.helpController = new HelpController(helpMenu);
    }

    @Test
    public void selectBack() {
        helpController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }
}
