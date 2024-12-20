package com.chickengame.controller.game;

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
    public void step(Game game, GUI gui, GUI.Action action) {
        switch(action)
        {
            case INVERT -> invertChickenGravity();
        }
    }

    private void invertChickenGravity()
    {
        if(super.getLocation().isCharge())
        {
            super.getLocation().setInverted(!super.getLocation().isInverted());
            super.getLocation().setCharge(false);
        }
    }
    public void moveY()
    {
        Position old = getLocation().getPosition();
        old.setY(getLocation().isInverted()? old.getY()-1:old.getY()+1);
    }

    public void stopX()
    {
        Position old = getLocation().getPosition();
        old.setX(old.getX()-1);
    }
}
