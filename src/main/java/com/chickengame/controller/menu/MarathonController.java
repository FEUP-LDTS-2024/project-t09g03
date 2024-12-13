package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.HarmObject;
import com.chickengame.model.game.elements.Wall;
import com.chickengame.model.game.map.Map;

import java.io.IOException;

public class MarathonController extends Controller<Map> {
    private final ChickenController chickencontroller;
    public MarathonController(Map location) {
        super(location);
        this.chickencontroller = new ChickenController(location.getChicken());
    }

    @Override
    public void step(Game game,GUI gui ,GUI.Action action) {
        this.movecamera();
        chickencontroller.step(game,gui,action);
    }
    private void movecamera()
    {
        for(Wall e : getLocation().getWalls())
        {
            Position old = e.getPosition();
            e.setPosition(new Position(old.getX()-1,old.getY()));
        }
        for(HarmObject e : getLocation().getHarmObjects())
        {
            e.setPosition(new Position(e.getPosition().getX()-1,e.getPosition().getY()));
        }
    }





}
