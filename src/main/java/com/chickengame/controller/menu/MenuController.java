package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.game.map.Menu;
import com.chickengame.state.MarathonState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu location) {
        super(location);
    }

    //wip
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getLocation().previousEntry();
                break;
            case DOWN:
                getLocation().nextEntry();
                break;
            case SELECT:
                if (getLocation().isSelectedExit()) game.setState(null);
                if (getLocation().isSelectedStart()) game.setState(new MarathonState(new MapBuilder(path).createArena()));
        }
    }
}
