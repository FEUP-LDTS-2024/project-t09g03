package com.chickengame.state.game;

import com.chickengame.Game;
import com.chickengame.controller.game.MarathonController;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.game.map.MarathonViewer;
import org.junit.jupiter.api.Assertions;
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

        Mockito.when(marathonMap.getChicken()).thenReturn(new Chicken(0,0,1));
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

    @Test
    public void marathonStateCreate()
    {
        MarathonState marathonState = new MarathonState(marathonMap);
        Assertions.assertNotNull(marathonState.getStateController());
        Assertions.assertNotNull(marathonState.getStateViewer());

    }
}
