package com.chickengame.state;

import com.chickengame.Game;
import com.chickengame.controller.game.MarathonController;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.model.menus.Menu;
import com.chickengame.state.game.MarathonState;
import com.chickengame.viewer.game.map.MarathonViewer;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MarathonStateTest {
    private MarathonState marathonState;
    private MarathonMap marathonMap;
    private MarathonController marathonController;
    private MarathonViewer marathonViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.marathonController = Mockito.mock(MarathonController.class);
        this.marathonViewer = Mockito.mock(MarathonViewer.class);
        this.marathonMap = Mockito.mock(MarathonMap.class);
        this.game = Mockito.mock(Game.class);
    }

    @Test
    public void marathonState() throws IOException {
        this.marathonState = new MarathonState(marathonMap)
        {
            @Override
            public MarathonViewer getStateViewer()
            {
                return marathonViewer;
            }
            @Override
            public MarathonController getStateController()
            {
                return marathonController;
            }
        };

        marathonState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(marathonController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(marathonViewer, Mockito.times(1)).draw(gui);
    }
}
