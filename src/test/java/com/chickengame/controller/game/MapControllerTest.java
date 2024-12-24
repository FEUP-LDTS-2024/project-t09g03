package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.menus.GameEndState;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;

public class MapControllerTest {

    private Game game;
    private Map map;
    private Chicken chicken;
    private ChickenController chickenController;
    private GUI gui;
    private MapController mapController;
    private int offset = 5;
    InOrder inOrder;


    @BeforeEach @BeforeProperty
    void Helper()
    {
        game = Mockito.mock(Game.class);
        map = Mockito.mock(Map.class);
        chicken = Mockito.mock(Chicken.class);
        chickenController = Mockito.mock(ChickenController.class);
        Mockito.when(chickenController.getLocation()).thenReturn(chicken);
        mapController = new MapController(map,chickenController,offset);
        gui = Mockito.mock(GUI.class);
        inOrder = inOrder(game, chicken,chickenController);
    }
    /*
    @Property
    void verifychickenout(@ForAll int x, @ForAll int y, @ForAll int width, @ForAll int height)
    {
        Mockito.when(chicken.getPosition()).thenReturn(position);
        Mockito.when(position.getX()).thenReturn(x);
        Mockito.when(position.getY()).thenReturn(y);
        Mockito.when(chicken.getWidth()).thenReturn(width);
        Mockito.when(chicken.getHeight()).thenReturn(height);
        Mockito.when(map.collidesHarmObject(Mockito.anyInt(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
        if(width+x<=0 || height+y<0)
        {
            inOrder.verify(game, Mockito.calls(1)).setState(any(GameEndState.class));
        }else
        {
            inOrder.verify(game, Mockito.calls(0)).setState(any(GameEndState.class));
        }

    }

*/



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

        inOrder.verify(chickenController, Mockito.times(5)).step(game,gui,action);
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
