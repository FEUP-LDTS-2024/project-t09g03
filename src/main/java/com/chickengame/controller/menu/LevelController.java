package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMap;

public class LevelController extends Controller<LevelMap> {
    private final MapController mapController;


    public LevelController(LevelMap location) {
        super(location);
        mapController = new MapController(getLocation().getMap(),getLocation().getChicken());
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action) {
        mapController.step(game, gui, action);
    }
}
