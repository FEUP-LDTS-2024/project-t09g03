package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;

public class ChickenController extends Controller<Chicken> {
    public ChickenController(Chicken location) {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui,GUI.Action action) {
        switch(action)
        {
            case INVERT -> invertChickenGravity();
        }
        move();
    }
    private void invertChickenGravity()
    {
        if(super.getLocation().isCharge())
        {
            super.getLocation().setMovingDown(!super.getLocation().isMovingDown());
        }
    }
    private void move()
    {
        Position old = getLocation().getPosition();
        getLocation().setPosition(new Position(old.getX(), getLocation().isMovingDown()? old.getY()+1:old.getY()-1));
    }
}
