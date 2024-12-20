package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.GameEnd;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.GameEndState;

public class MapController extends Controller<Map>
{
    private final Chicken chicken;
    private final ChickenController chickenController;
    private final int adapter;

    public MapController(Map location, Chicken chicken, int adapter)
    {
        super(location);
        this.chicken = chicken;
        chickenController = new ChickenController(chicken);
        this.adapter = adapter;
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        boolean chickenOutX = (chicken.getPosition().getX() + chicken.getWidth() <= 0);
        boolean chickenOutUp = (chicken.getPosition().getY() + chicken.getHeight() <= 0);
        boolean chickenOutDown = (chicken.getPosition().getY() >= 375);

        int chickenXMin = chicken.getPosition().getX();
        int chickenXMax = chickenXMin + chicken.getWidth();
        int chickenYMin = chicken.getPosition().getY();
        int chickenYMax = chickenYMin + chicken.getHeight();

        if(getLocation().collidesHarmObject(chickenXMin,chickenXMax, chickenYMin,chickenYMax) || chickenOutX || chickenOutUp || chickenOutDown)
        {
            game.setState(new GameEndState(new GameEnd(true)));
        }
        for(int i = 0; i < adapter;i++)
        {
            chickenXMin = chicken.getPosition().getX();
            chickenXMax = chickenXMin + chicken.getWidth();
            chickenYMin = chicken.getPosition().getY();
            chickenYMax = chickenYMin + chicken.getHeight();

            moveCamera(-1);

            boolean chickenCollidesDown = (!chicken.isInverted() && getLocation().collidesDown(chickenXMin,chickenXMax,chickenYMax));
            boolean chickenCollidesUp = (chicken.isInverted() && getLocation().collidesUp(chickenXMin,chickenXMax,chickenYMin));

            if(getLocation().collidesHarmObject(chickenXMin,chickenXMax,chickenYMin,chickenYMax))
            {
                break;
            }

            if(chickenCollidesDown || chickenCollidesUp)
            {
                chicken.setCharge(true);
            }
            else
            {
                chickenController.moveY();
            }

            if(getLocation().collidesRight(chickenXMax,chickenYMin,chickenYMax))
            {
                chickenController.stopX();
            }

            chickenController.step(game,gui,action);
        }

    }

    public void moveCamera(int offset)
    {
        getLocation().moveMap(offset);
    }
}
