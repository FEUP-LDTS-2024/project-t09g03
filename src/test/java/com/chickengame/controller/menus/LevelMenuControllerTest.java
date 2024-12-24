package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.state.game.LevelState;
import com.chickengame.state.menus.MainMenuState;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class LevelMenuControllerTest {
    private Game game;
    private GUI gui;
    private LevelMenuController levelMenuController;
    private LevelMenu levelMenu;
    private Button button;
    private ButtonLevel buttonLevel;

    @BeforeEach
    @BeforeProperty
    public void helper() {
        this.levelMenu = Mockito.mock(LevelMenu.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.button = Mockito.mock(Button.class);
        this.buttonLevel = Mockito.mock(ButtonLevel.class);

        Mockito.when(levelMenu.getCurrentButton()).thenReturn(button);

        this.levelMenuController = new LevelMenuController(levelMenu);
    }

    @Property
    public void upTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(levelMenu);
        for (int i = 1; i < repetitions; i++) {
            this.levelMenuController.step(game, gui, GUI.Action.UP);
            Mockito.verify(levelMenu, Mockito.times(i)).selectNext();
        }
    }

    @Property
    public void rightTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(levelMenu);
        for (int i = 1; i < repetitions; i++) {
            this.levelMenuController.step(game, gui, GUI.Action.RIGHT);
            Mockito.verify(levelMenu, Mockito.times(i)).selectNext();
        }
    }

    @Property
    public void downTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(levelMenu);
        for (int i = 1; i < repetitions; i++) {
            this.levelMenuController.step(game, gui, GUI.Action.DOWN);
            Mockito.verify(levelMenu, Mockito.times(i)).selectBack();
        }
    }

    @Property
    public void leftTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(levelMenu);
        for (int i = 1; i < repetitions; i++) {
            this.levelMenuController.step(game, gui, GUI.Action.LEFT);
            Mockito.verify(levelMenu, Mockito.times(i)).selectPrev();
        }
    }

    @Test
    public void selectBack() {
        Mockito.when(button.getType()).thenReturn(Button.Type.Back);
        levelMenuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }

    @Test
    public void selectLevel() {
        Mockito.when(buttonLevel.getType()).thenReturn(Button.Type.Level);
        Mockito.when(levelMenu.getCurrentButton()).thenReturn(buttonLevel);
        Mockito.when(buttonLevel.getLevel()).thenReturn(2);
        levelMenuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(levelMenu, Mockito.times(2)).getCurrentButton();
        Mockito.verify(buttonLevel, Mockito.times(1)).getLevel();
        Mockito.verify(game,Mockito.times(1)).setState(Mockito.any(LevelState.class));
    }
}
