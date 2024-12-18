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
    private final int adapter;
    public MapController(Map location, Chicken chicken, int adapter) {
        super(location);
        this.chicken = chicken;
        chickenController = new ChickenController(chicken);
        this.adapter = adapter;
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        boolean chickenOutX = (chicken.getPosition().getX() + chicken.getWIDTH() <= 0);
        boolean chickenOutUp = (chicken.getPosition().getY() + chicken.getHEIGHT() <= 0);
        boolean chickenOutDown = (chicken.getPosition().getY() > 375);

        if(getLocation().colidesHarmObject(chicken) || getLocation().colidesHarmObject(chicken) || chickenOutX || chickenOutUp || chickenOutDown)
        {
            game.setState(new GameOverState(new GameOver()));
        }

        for(int i = 0; i< adapter;i++)
        {
            this.movecamera(-1);
            boolean chickenCollidesDown = (chicken.isMovingDown() && (getLocation().colidesDown(chicken)|| getLocation().colidesDown(chicken)));
            boolean chickenCollidesUp = (!chicken.isMovingDown() && (getLocation().colidesUp(chicken)||getLocation().colidesUp(chicken)));

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

    public void movecamera(int offset)
    {
        getLocation().moveMap(offset);
    }
}
