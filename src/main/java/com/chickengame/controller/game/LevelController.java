package com.chickengame.controller.game;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.Win;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.state.WinState;

public class LevelController extends Controller<LevelMap> {
    private final MapController mapController;

    public LevelController(LevelMap location) {
        super(location);
        mapController = new MapController(getLocation().getMap(),getLocation().getChicken(), 5);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action) {
        Position old = getLocation().getFinishLine().getPosition();
        getLocation().getFinishLine().setPosition(new Position(old.getX()-5,old.getY()));
        if(getLocation().getChicken().getPosition().getX()>=getLocation().getFinishLine().getPosition().getX())
        {
            game.setState(new WinState(new Win()));
        }
        mapController.step(game, gui, action);
    }
}
