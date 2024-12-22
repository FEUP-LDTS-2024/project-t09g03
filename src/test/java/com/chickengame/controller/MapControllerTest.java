package com.chickengame.controller;

import com.chickengame.Game;
import com.chickengame.controller.game.ChickenController;
import com.chickengame.controller.game.MapController;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.GameEndState;
import com.chickengame.state.State;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import net.jqwik.api.lifecycle.AfterProperty;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.NoInteractionsWanted;

import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class MapControllerTest {

    private Game game;
    private Map map;
    private Chicken chicken;
    private ChickenController chickenController;
    private GUI gui;
    private Position position;
    private MapController mapController;
    private int offset = 5;
    InOrder inOrder;


    @BeforeEach @BeforeProperty
    void Helper()
    {
        position = Mockito.mock(Position.class);
        game = Mockito.mock(Game.class);
        map = Mockito.mock(Map.class);
        chicken = Mockito.mock(Chicken.class);
        chickenController = Mockito.mock(ChickenController.class);
        Mockito.when(chickenController.getLocation()).thenReturn(chicken);
        mapController = new MapController(map,chickenController,offset);
        gui = Mockito.mock(GUI.class);
        inOrder = inOrder(game, chicken,chickenController);
    }

    void verifychickenoutX()
    {
        Mockito.when(position.getX()).thenReturn(-40);
        Mockito.when(position.getY()).thenReturn(-40);
        Mockito.when(chicken.getPosition()).thenReturn(position);
        Mockito.when(chicken.getWidth()).thenReturn(20);
        Mockito.when(chicken.getHeight()).thenReturn(20);
        mapController.step(game,gui, GUI.Action.NONE);

        Mockito.verify(game, Mockito.times(1)).setState(any(GameEndState.class));


    }




    @Property
    void verifychickengettingkilled(@ForAll("ActionArbitrary") GUI.Action action,@ForAll boolean colidesHarmObject)
    {
        Mockito.when(chicken.getPosition()).thenReturn(new Position(0,0));
        Mockito.when(chicken.getHeight()).thenReturn(40);
        Mockito.when(chicken.getWidth()).thenReturn(40);
        Mockito.when(map.collidesHarmObject(Mockito.anyInt(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(colidesHarmObject);
        mapController.step(game, gui,  action);

        if(colidesHarmObject)
        {
            inOrder.verify(game, Mockito.atLeast(1)).setState(any(GameEndState.class));
        }
    }

    @Property
    void verifycoligions(@ForAll("ActionArbitrary") GUI.Action action, @ForAll boolean collidesUp,@ForAll boolean collidesDown, @ForAll boolean colidesright)
    {
        Mockito.when(chicken.getPosition()).thenReturn(new Position(0,0));
        Mockito.when(chicken.getHeight()).thenReturn(40);
        Mockito.when(chicken.getWidth()).thenReturn(40);
        Mockito.when(chickenController.getLocation()).thenReturn(chicken);
        Mockito.when(map.collidesDown(Mockito.anyInt(), Mockito.anyInt(),Mockito.anyInt())).thenReturn(collidesDown);
        Mockito.when(map.collidesRight(Mockito.anyInt(), Mockito.anyInt(),Mockito.anyInt())).thenReturn(colidesright);
        Mockito.when(map.collidesUp(Mockito.anyInt(), Mockito.anyInt(),Mockito.anyInt())).thenReturn( collidesUp);
        Mockito.when(map.collidesHarmObject(Mockito.anyInt(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
        mapController = new MapController(map,chickenController,offset);

        mapController.step(game, gui, action);

        Mockito.verify(chickenController, Mockito.times(5)).step(game,gui,action);
    }

    @AfterEach
    void cleaner()
    {

    }

    @Provide
    Arbitrary<GUI.Action> ActionArbitrary() {
        return Arbitraries.of(GUI.Action.INVERT, GUI.Action.DOWN, GUI.Action.UP, GUI.Action.QUIT, GUI.Action.LEFT, GUI.Action.RIGHT, GUI.Action.SELECT);
    }

    @Test
    void moveTest()
    {
        MapController mapController = new MapController(map,chickenController,offset);
        mapController.moveCamera(offset);
        Mockito.verify(map, Mockito.times(1)).moveMap(offset);
    }





}
