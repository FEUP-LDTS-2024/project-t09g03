package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.MarathonMap;


public class MarathonController extends Controller<MarathonMap>
{
    private MapController currentMapController;
    private MapController nextMapController;
    private int offsetCounter = 0;
    private static final int adapter = 5;

    public MarathonController(MarathonMap location)
    {
        super(location);
        currentMapController = new MapController(getLocation().getCurrent(),new ChickenController(getLocation().getChicken()),adapter);
        nextMapController = new MapController(getLocation().getNextMap(),new ChickenController(getLocation().getChicken()),adapter);
    }
    @Override
    public void step(Game game,GUI gui ,GUI.Action action)
    {
        int locationMin = getLocation().getChicken().getPosition().getX();
        int locationMax = getLocation().getChicken().getPosition().getX() + getLocation().getChicken().getWidth();

        if(getLocation().getCurrent().getSizeX()-offsetCounter < locationMin)
        {
           currentMapController.moveCamera(-5);
           nextMapController.step(game, gui, action);
        }
        else if(getLocation().getCurrent().getSizeX()-offsetCounter > locationMax)
        {
            currentMapController.step(game, gui, action);
            nextMapController.moveCamera(-5);
        }
        else
        {
            currentMapController.step(game, gui, action);
            nextMapController.step(game, gui, action);
        }
        offsetCounter += adapter;
        if(offsetCounter > getLocation().getCurrent().getSizeX())
        {
            changeMap();
        }
    }

    private void changeMap()
    {

        getLocation().getCurrent().resetPosition();
        getLocation().setNextMap();
        offsetCounter = 0;
        currentMapController = new MapController(getLocation().getCurrent(),new ChickenController(getLocation().getChicken()),adapter);
        nextMapController = new MapController(getLocation().getNextMap(),new ChickenController(getLocation().getChicken()),adapter);
    }
}
