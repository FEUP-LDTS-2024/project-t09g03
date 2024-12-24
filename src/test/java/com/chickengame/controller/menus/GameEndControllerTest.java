package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.state.menus.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class GameEndControllerTest {
    private Game game;
    private GUI gui;
    private GameEndController gameEndController;
    private GameEndMenu gameEndMenu;

    @BeforeEach
    public void helper() {
        this.gameEndMenu = Mockito.mock(GameEndMenu.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);

        this.gameEndController = new GameEndController(gameEndMenu);
    }

    @Test
    public void selectBack() {
        gameEndController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }
}
