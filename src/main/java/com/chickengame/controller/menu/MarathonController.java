package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.HarmObject;
import com.chickengame.model.game.elements.Wall;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.menu.Menu;
import com.chickengame.state.MenuState;


public class MarathonController extends Controller<Map> {
    private final ChickenController chickencontroller;
    public MarathonController(Map location) {
        super(location);
        this.chickencontroller = new ChickenController(location.getChicken());
    }
    int adapter = 1;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {
        this.movecamera();
        boolean chickenOut = (getLocation().getChicken().getPosition().getX() + getLocation().getChicken().getWIDTH() <= 0);
        chickenOut |= getLocation().getChicken().getPosition().getY()+getLocation().getChicken().getHEIGHT()<0 | getLocation().getChicken().getPosition().getY()>375;
        if(getLocation().colidesHarmObject() || chickenOut)
        {
            game.setState(new MenuState(new Menu()));
        }

        boolean chickenCollidesDown = (getLocation().getChicken().isMovingDown() && getLocation().colidesDown());
        boolean chickenCollidesUp = (!getLocation().getChicken().isMovingDown() && getLocation().colidesUp());

        if(chickenCollidesDown || chickenCollidesUp)
        {
            getLocation().getChicken().setCharge(true);
        }
        else
        {
            chickencontroller.moveY(adapter);
        }

        if(getLocation().colidesRight())
        {
            chickencontroller.stopX(adapter);
        }
        chickencontroller.step(game,gui,action);
    }
    private void movecamera()
    {
        for(Wall wall : getLocation().getWalls())
        {
            Position old = wall.getPosition();

            wall.setPosition((new Position(old.getX()-adapter,old.getY())));
        }
        for(HarmObject harmObject : getLocation().getHarmObjects())
        {
            harmObject.setPosition(new Position(harmObject.getPosition().getX()-adapter,harmObject.getPosition().getY()));
        }
    }
}
