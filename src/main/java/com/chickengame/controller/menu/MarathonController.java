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
    private int adapter = 5;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {

        boolean chickenOutX = (getLocation().getChicken().getPosition().getX() + getLocation().getChicken().getWIDTH() <= 0);
        boolean chickenOutUp = (getLocation().getChicken().getPosition().getY() + getLocation().getChicken().getHEIGHT() <= 0);
        boolean chickenOutDown = (getLocation().getChicken().getPosition().getY() > 375);

        if(getLocation().colidesHarmObject() || chickenOutX || chickenOutUp || chickenOutDown)
        {
            game.setState(new MenuState(new Menu()));
        }

        for(int i = 0; i< adapter;i++)
        {
            this.movecamera();
            boolean chickenCollidesDown = (getLocation().getChicken().isMovingDown() && getLocation().colidesDown());
            boolean chickenCollidesUp = (!getLocation().getChicken().isMovingDown() && getLocation().colidesUp());

            if(getLocation().colidesHarmObject())
            {
                break;
            }
            if(chickenCollidesDown || chickenCollidesUp)
            {
                getLocation().getChicken().setCharge(true);
            }
            else
            {
                chickencontroller.moveY();
            }

            if(getLocation().colidesRight())
            {
                chickencontroller.stopX();
            }
            chickencontroller.step(game,gui,action);
        }

    }
    private void movecamera()
    {
        for(Wall wall : getLocation().getWalls())
        {
            Position old = wall.getPosition();

            wall.setPosition((new Position(old.getX()-1,old.getY())));
        }
        for(HarmObject harmObject : getLocation().getHarmObjects())
        {
            harmObject.setPosition(new Position(harmObject.getPosition().getX()-1,harmObject.getPosition().getY()));
        }
    }





}
