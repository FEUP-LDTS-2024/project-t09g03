package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.gui.LanternaDraw;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.HarmObject;
import com.chickengame.model.game.elements.Wall;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.model.game.menu.Menu;
import com.chickengame.state.MenuState;


public class MarathonController extends Controller<MarathonMap> {
    private final ChickenController chickencontroller;
    private int offsetCounter = 0;
    public MarathonController(MarathonMap location) {
        super(location);
        this.chickencontroller = new ChickenController(location.getChicken());
    }
    private int adapter = 5;

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {

        boolean chickenOutX = (getLocation().getChicken().getPosition().getX() + getLocation().getChicken().getWIDTH() <= 0);
        boolean chickenOutUp = (getLocation().getChicken().getPosition().getY() + getLocation().getChicken().getHEIGHT() <= 0);
        boolean chickenOutDown = (getLocation().getChicken().getPosition().getY() > 375);

        if(getLocation().getMaps().get(getLocation().getCurrent()).colidesHarmObject(getLocation().getChicken())|| getLocation().getMaps().get(getLocation().getNextMap()).colidesHarmObject(getLocation().getChicken()) || chickenOutX || chickenOutUp || chickenOutDown)
        {
            game.setState(new MenuState(new Menu()));
        }

        for(int i = 0; i< adapter;i++)
        {
            this.movecamera();
            boolean chickenCollidesDown = (getLocation().getChicken().isMovingDown() && (getLocation().getMaps().get(getLocation().getCurrent()).colidesDown(getLocation().getChicken())|| getLocation().getMaps().get(getLocation().getNextMap()).colidesDown(getLocation().getChicken())));
            boolean chickenCollidesUp = (!getLocation().getChicken().isMovingDown() && (getLocation().getMaps().get(getLocation().getCurrent()).colidesUp(getLocation().getChicken())||getLocation().getMaps().get(getLocation().getNextMap()).colidesUp(getLocation().getChicken())));

            if(getLocation().getMaps().get(getLocation().getCurrent()).colidesHarmObject(getLocation().getChicken()))
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

            if(getLocation().getMaps().get(getLocation().getCurrent()).colidesRight(getLocation().getChicken()))
            {
                chickencontroller.stopX();
            }
            chickencontroller.step(game,gui,action);
        }

    }
    private void movecamera()
    {
        offsetCounter++;
        if(offsetCounter>getLocation().getMaps().get(getLocation().getCurrent()).getSizeX())
        {

            getLocation().getMaps().get(getLocation().getCurrent()).resetMapposition();
            getLocation().setNextMap();
            offsetCounter = 0;
        }
        getLocation().getMaps().get(getLocation().getCurrent()).moveMap(-1);
        getLocation().getMaps().get(getLocation().getNextMap()).moveMap(-1);
    }





}
