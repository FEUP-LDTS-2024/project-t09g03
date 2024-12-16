package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMapBuilder;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.menu.Button;
import com.chickengame.model.menu.Menu;
import com.chickengame.model.levelmenu.ButtonLevel;
import com.chickengame.model.levelmenu.LevelMenu;
import com.chickengame.state.LevelState;
import com.chickengame.state.MenuState;

public class LevelMenuController extends Controller<LevelMenu> {
    public LevelMenuController(LevelMenu location) {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action) {

        switch(action)
        {
            case UP, RIGHT ->getLocation().selectNext();
            case DOWN ->getLocation().selectBack();
            case LEFT ->getLocation().selectPrev();
            case SELECT ->
            {
                switch (getLocation().getCurrentButton().getType())
                {
                    case Button.Type.Back->game.setState(new MenuState(new Menu()));
                    case Button.Type.Level ->runlevel(game,((ButtonLevel)getLocation().getCurrentButton()).getLevel());
                }
            }
        }
    }

    private void runlevel(Game game, int level)
    {
        game.setState(new LevelState(new LevelMapBuilder().createLevelMap("/maps/",new MapBuilder(), game.getChickenSkin(), level)));
    }
}
