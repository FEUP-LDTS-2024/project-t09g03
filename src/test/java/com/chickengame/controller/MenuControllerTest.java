package com.chickengame.controller;

import com.chickengame.Game;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.state.HelpState;
import com.chickengame.state.LevelMenuState;
import com.chickengame.state.MarathonState;
import com.chickengame.state.ShopState;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.IOException;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.step;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;

public class MenuControllerTest {
    private Game game;
    private GUI gui;
    private MainMenu mainmenu;
    private MainMenuController menuController;
    private Button button;


    @BeforeEach @BeforeProperty
    public void setup() {
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.mainmenu = Mockito.mock(MainMenu.class);
        this.button = Mockito.mock(Button.class);


        Mockito.when(mainmenu.getSelected()).thenReturn(button);
        this.menuController = new MainMenuController(mainmenu);
    }

    @Property
    public void downTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(mainmenu);
        for (int i = 1; i < repetitions; i++) {
            this.menuController.step(game, gui, GUI.Action.DOWN);
            Mockito.verify(mainmenu, Mockito.times(i)).nextButton();
        }
    }

    @Property
    public void upTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(mainmenu);
        for (int i = 1; i < repetitions; i++) {
            this.menuController.step(game, gui, GUI.Action.UP);
            Mockito.verify(mainmenu, Mockito.times(i)).previousButton();
        }
    }

    @Test
    public void selectQuit() throws IOException {
        Mockito.when(button.getType()).thenReturn(Button.Type.Exit);
        menuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(gui, Mockito.times(1)).close();
    }

    @Test
    public void selectPlay()  {
        Mockito.when(button.getType()).thenReturn(Button.Type.Play);
        menuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MarathonState.class));
    }

    @Test
    public void selectShop()  {
        Mockito.when(button.getType()).thenReturn(Button.Type.Shop);
        menuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(ShopState.class));
    }

    @Test
    public void selectLevelMenu()  {
        Mockito.when(button.getType()).thenReturn(Button.Type.LevelMenu);
        menuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LevelMenuState.class));
    }

    @Test
    public void selectHelp()  {
        Mockito.when(button.getType()).thenReturn(Button.Type.Help);
        menuController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(HelpState.class));
    }

    /*
    @Test
    public void catchException()  {


    }*/
}
