package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.state.menus.MainMenuState;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class GameEndControllerTest {
    private Game game;
    private GUI gui;
    private GameEndController gameEndController;
    private GameEndMenu gameEndMenu;
    private Button button;

    @BeforeEach
    public void helper() {
        this.gameEndMenu = Mockito.mock(GameEndMenu.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.button = Mockito.mock(Button.class);

        this.gameEndController = new GameEndController(gameEndMenu);
    }

    @Test
    public void selectBack() {
        Mockito.when(button.getType()).thenReturn(Button.Type.Back);
        gameEndController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }
}
