package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.menus.GameEndMenu;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.state.GameEndState;

public class LevelController extends Controller<LevelMap>
{
    private final MapController mapController;
    private static final int adapter = 5;

    public LevelController(LevelMap location)
    {
        super(location);
        mapController = new MapController(getLocation().getMap(),getLocation().getChicken(), adapter);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        Position old = getLocation().getFinishLine().getPosition();
        getLocation().getFinishLine().setPosition(new Position(old.getX()-adapter,old.getY()));
        if(getLocation().getChicken().getPosition().getX() >= getLocation().getFinishLine().getPosition().getX())
        {
            game.setState(new GameEndState(new GameEndMenu(false)));
        }
        mapController.step(game, gui, action);
    }
}
