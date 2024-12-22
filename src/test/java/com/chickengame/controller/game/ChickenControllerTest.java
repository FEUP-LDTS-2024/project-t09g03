package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.inOrder;

public class ChickenControllerTest {


    private Chicken chicken;
    private Game game;
    private GUI gui;
    private InOrder inOrder;
    private Position position;
    private ChickenController chickenController;

    @BeforeProperty
    void Helper()
    {
        this.chicken =  Mockito.mock(Chicken.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.position = Mockito.mock(Position.class);
        inOrder = inOrder(chicken);
        this.chickenController = new ChickenController(chicken);
    }

    @Property
    void stepPropertyTest(@ForAll boolean charge, @ForAll boolean inverted, @ForAll("ActionArbitrary") GUI.Action action)
    {
        Mockito.when(chicken.isCharge()).thenReturn(charge);
        Mockito.when(chicken.isInverted()).thenReturn(inverted);
        chickenController.step(game,gui, action);
        if(action == GUI.Action.INVERT)
        {
            if(charge)
            {
                inOrder.verify(chicken, Mockito.calls(1)).isCharge();
                inOrder.verify(chicken, Mockito.calls(1)).isInverted();
                inOrder.verify(chicken, Mockito.calls(1)).setInverted(!inverted);
                inOrder.verify(chicken, Mockito.calls(1)).setCharge(false);
            }
            else
            {
                inOrder.verify(chicken, Mockito.calls(1)).isCharge();
                inOrder.verify(chicken, Mockito.never()).isInverted();
                inOrder.verify(chicken, Mockito.never()).setInverted(!inverted);
                inOrder.verify(chicken, Mockito.never()).setCharge(false);
            }
        }else
        {
                inOrder.verify(chicken, Mockito.never()).isCharge();
                inOrder.verify(chicken, Mockito.never()).isInverted();
                inOrder.verify(chicken, Mockito.never()).setInverted(!inverted);
                inOrder.verify(chicken, Mockito.never()).setCharge(false);
        }
    }

    @Provide
    Arbitrary<GUI.Action> ActionArbitrary() {
        return Arbitraries.of(GUI.Action.INVERT, GUI.Action.DOWN, GUI.Action.UP, GUI.Action.QUIT, GUI.Action.LEFT, GUI.Action.RIGHT, GUI.Action.SELECT);
    }

    @Property
    void moveYTest(@ForAll int y, @ForAll boolean inverted )
    {
        //inOrder = inOrder(chicken,position);
        Mockito.when(position.getY()).thenReturn(y);
        Mockito.when(chicken.getPosition()).thenReturn(position);
        Mockito.when(chicken.isInverted()).thenReturn(inverted);
        chickenController.moveY();
        inOrder = inOrder(chicken,position);
        inOrder.verify(chicken,Mockito.atLeastOnce()).getPosition();
        inOrder.verify(position,Mockito.calls(1)).setY(inverted? y-1:y+1);
    }
    @Property
    void moveXTest(@ForAll int x)
    {
        //inOrder = inOrder(chicken,position);
        Mockito.when(position.getX()).thenReturn(x);
        Mockito.when(chicken.getPosition()).thenReturn(position);
        chickenController.stopX();
        inOrder = inOrder(chicken,position);
        inOrder.verify(chicken,Mockito.atLeastOnce()).getPosition();
        inOrder.verify(position,Mockito.calls(1)).setX(x-1);
    }



}
