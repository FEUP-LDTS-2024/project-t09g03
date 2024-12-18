package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.GameOver;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.state.GameOverState;

import java.util.ArrayList;
import java.util.List;


public class MarathonController extends Controller<MarathonMap> {
    private final ChickenController chickencontroller;
    private MapController currentMapController;
    private MapController nextMapController;
    private int offsetCounter = 0;
    private static final int adapter = 5;
    public MarathonController(MarathonMap location) {
        super(location);
        this.chickencontroller = new ChickenController(location.getChicken());

    }
    @Override
    public void step(Game game,GUI gui ,GUI.Action action)
    {
        currentMapController = new MapController(getLocation().getCurrent(),getLocation().getChicken(),adapter);
        nextMapController = new MapController(getLocation().getNextMap(),getLocation().getChicken(),adapter);
        int locationMin =getLocation().getChicken().getPosition().getX();
        int locationMax =getLocation().getChicken().getPosition().getX()+getLocation().getChicken().getWIDTH();

        if(getLocation().getCurrent().getSizeX()-offsetCounter<locationMin)
        {
           currentMapController.movecamera(-5);
           nextMapController.step(game, gui, action);
        }else if(getLocation().getCurrent().getSizeX()-offsetCounter>locationMax)
        {
            currentMapController.step(game, gui, action);
            nextMapController.movecamera(-5);
        }else
        {
            currentMapController.step(game, gui, action);
            nextMapController.step(game, gui, action);
        }
        offsetCounter+=5;
        if(offsetCounter>getLocation().getCurrent().getSizeX())
        {
            changemap();
        }

    }

    private void changemap()
    {
        getLocation().getCurrent().resetMapposition();
        getLocation().setNextMap();
        offsetCounter = 0;
    }




}
