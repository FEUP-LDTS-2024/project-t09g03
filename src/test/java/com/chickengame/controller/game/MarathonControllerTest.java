package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.elements.Chicken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MarathonControllerTest {
    private MarathonMap marathonMap;
    private MarathonController marathonController;
    private Map currentMap;
    private Map nextMap;
    private Chicken chicken;
    private Game game;
    private GUI gui;

    @BeforeEach
    void helper() {
        chicken = Mockito.mock(Chicken.class);
        currentMap = Mockito.mock(Map.class);
        nextMap = Mockito.mock(Map.class);
        marathonMap = Mockito.mock(MarathonMap.class);

        when(marathonMap.getChicken()).thenReturn(chicken);
        when(marathonMap.getCurrent()).thenReturn(currentMap);
        when(marathonMap.getNextMap()).thenReturn(nextMap);

        when(currentMap.getSizeX()).thenReturn(10);
        when(chicken.getPosition()).thenReturn(Mockito.mock(Position.class));
        when(chicken.getWidth()).thenReturn(10);

        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);

        marathonController = new MarathonController(marathonMap);
    }

    @Test
    void stepCurrentMap() {
        when(chicken.getPosition().getX()).thenReturn(50);

        marathonController.step(game, gui, GUI.Action.NONE);

        verify(currentMap, times(2)).getSizeX();
        verify(chicken, times(23)).getPosition();
        verify(currentMap, times(1)).moveMap(-5);
    }

    @Test
    void stepNextMap() {
        when(currentMap.getSizeX()).thenReturn(50);
        when(chicken.getPosition().getX()).thenReturn(95);

        marathonController.step(game, gui, GUI.Action.NONE);

        verify(currentMap, atLeastOnce()).getSizeX();
        Mockito.verify(currentMap, Mockito.times(1)).moveMap(-5);
    }

    @Test
    void changeMap() {
        marathonController.step(game, gui, GUI.Action.NONE);

        for (int i = 0; i <3 ; i++) {
            marathonController.step(game, gui, GUI.Action.NONE);
        }

        verify(marathonMap, times(1)).setNextMap();
        verify(currentMap, times(1)).resetPosition();
    }

    @Test
    void cameraAdjustment() {
        when(currentMap.getSizeX()).thenReturn(100);
        when(chicken.getPosition().getX()).thenReturn(85);

        marathonController.step(game, gui, GUI.Action.NONE);

        verify(nextMap, atLeastOnce()).moveMap(-5);
    }
}
