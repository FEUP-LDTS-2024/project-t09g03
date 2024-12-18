package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.GameOver;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.Map;
import com.chickengame.state.GameOverState;

public class MapController extends Controller<Map> {
    private Chicken chicken;
    private final ChickenController chickenController;
    public MapController(Map location, Chicken chicken) {
        super(location);
        this.chicken = chicken;
        chickenController = new ChickenController(chicken);
    }

    private int adapter = 5;

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        boolean chickenOutX = (chicken.getPosition().getX() + chicken.getWidth() <= 0);
        boolean chickenOutUp = (chicken.getPosition().getY() + chicken.getHeight() <= 0);
        boolean chickenOutDown = (chicken.getPosition().getY() > 375);

        if(getLocation().colidesHarmObject(chicken) || chickenOutX || chickenOutUp || chickenOutDown)
        {
            game.setState(new GameOverState(new GameOver()));
        }

        for(int i = 0; i< adapter;i++)
        {
            this.movecamera();
            boolean chickenCollidesDown = (!chicken.isInverted() && getLocation().colidesDown(chicken) );
            boolean chickenCollidesUp = (chicken.isInverted() && getLocation().colidesUp(chicken));

            if(getLocation().colidesHarmObject(chicken))
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

            if(getLocation().colidesRight(chicken))
            {
                chickenController.stopX();
            }
            chickenController.step(game,gui,action);
        }

    }

    private void movecamera()
    {
        getLocation().moveMap(-1);
    }
}
