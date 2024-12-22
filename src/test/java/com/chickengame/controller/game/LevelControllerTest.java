package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.GameEndState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class LevelControllerTest {
    private LevelController levelController;
    private LevelMap levelMap;
    private Game game;
    private GUI gui;
    private MapController mapController;
    private Map map;
    private Chicken chicken;
    private Element element;
    private Position position;

    @BeforeEach
    public void helper()
    {
        this.levelMap = Mockito.mock(LevelMap.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.mapController = Mockito.mock(MapController.class);
        this.map = Mockito.mock(Map.class);
        this.chicken = Mockito.mock(Chicken.class);
        this.element = Mockito.mock(Element.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(levelMap.getMap()).thenReturn(map);
        Mockito.when(levelMap.getChicken()).thenReturn(chicken);
        Mockito.when(chicken.getPosition()).thenReturn(position);
        Mockito.when(levelMap.getFinishLine()).thenReturn(element);
        Mockito.when(element.getPosition()).thenReturn(position);
        Mockito.when(mapController.getLocation()).thenReturn(map);

        this.levelController = new LevelController(levelMap);
    }

    @Test
    public void stepNotWon()
    {
        LevelController controller = new LevelController(levelMap);
        Mockito.when(chicken.getPosition()).thenReturn(new Position(3, 5));
        Mockito.when(element.getPosition()).thenReturn(new Position(5, 5));

        controller.step(game, gui, GUI.Action.NONE);

        Mockito.verify(map, Mockito.times(5)).moveMap(-1);
    }

    @Test
    public void stepWin()
    {
        LevelController controller = new LevelController(levelMap);
        Mockito.when(chicken.getPosition()).thenReturn(new Position(6, 5));
        Mockito.when(element.getPosition()).thenReturn(new Position(5, 5));

        controller.step(game, gui, GUI.Action.NONE);

        Mockito.verify(game, Mockito.times(1)).setState(any(GameEndState.class));
    }
}
