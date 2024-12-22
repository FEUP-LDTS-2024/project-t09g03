package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.menus.GameEndState;

public class MapController extends Controller<Map> {
    private final Chicken chicken;
    private final ChickenController chickenController;
    private final int adapter;

    public MapController(Map location, ChickenController chickenController, int adapter) {
        super(location);
        this.chickenController = chickenController;
        this.chicken = chickenController.getLocation();
        this.adapter = adapter;
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action) {
        boolean chickenOutX = (chicken.getPosition().getX() + chicken.getWidth() <= 0);
        boolean chickenOutUp = (chicken.getPosition().getY() + chicken.getHeight() <= 0);
        boolean chickenOutDown = (chicken.getPosition().getY() >= 375);

        chickenOut(chickenOutX,chickenOutUp,chickenOutDown, game);

        int chickenXMin = chicken.getPosition().getX();
        int chickenXMax = chickenXMin + chicken.getWidth();
        int chickenYMin = chicken.getPosition().getY();
        int chickenYMax = chickenYMin + chicken.getHeight();

        colidesHarmObject(game, getLocation().collidesHarmObject(chickenXMin, chickenXMax, chickenYMin, chickenYMax));
        for (int i = 0; i < adapter; i++) {
            chickenXMin = chicken.getPosition().getX();
            chickenXMax = chickenXMin + chicken.getWidth();
            chickenYMin = chicken.getPosition().getY();
            chickenYMax = chickenYMin + chicken.getHeight();

            moveCamera(-1);

            boolean chickenCollidesDown = (!chicken.isInverted() && getLocation().collidesDown(chickenXMin, chickenXMax, chickenYMax));
            boolean chickenCollidesUp = (chicken.isInverted() && getLocation().collidesUp(chickenXMin, chickenXMax, chickenYMin));

            if (getLocation().collidesHarmObject(chickenXMin, chickenXMax, chickenYMin, chickenYMax)) {
                break;
            }
            colidesUpDown(chickenCollidesDown, chickenCollidesUp);
            colidesRight(chickenXMax, chickenYMin, chickenYMax);

            chickenController.step(game, gui, action);
        }
    }

    void chickenOut(boolean chickenOutX, boolean chickenOutUp, boolean chickenOutDown, Game game ){

        if(chickenOutX ||chickenOutUp ||chickenOutDown)
        {
            GameEndState endState = new GameEndState(new GameEndMenu("gameOver"));
            game.setState(endState);
        }
    }
    public void colidesHarmObject(Game game,boolean colidesharmobject)
    {
        if(colidesharmobject)
        {
            GameEndState endState = new GameEndState(new GameEndMenu("gameOver"));
            game.setState(endState);
        }
    }
    public void colidesUpDown(boolean chickenCollidesDown, boolean chickenCollidesUp)
    {
            if(chickenCollidesDown || chickenCollidesUp)
            {
                chicken.setCharge(true);
            }
            else
            {
                chickenController.moveY();
            }
    }
    public void colidesRight(int chickenXMax, int chickenYMin, int chickenYMax)
    {
            if(getLocation().collidesRight(chickenXMax,chickenYMin,chickenYMax))
            {
                chickenController.stopX();
            }
    }
    public void moveCamera(int offset)
    {
        getLocation().moveMap(offset);
    }
}
