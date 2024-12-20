package com.chickengame.controller.menu;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.Menu;
import com.chickengame.model.game.map.LevelMapBuilder;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.menu.Button;
import com.chickengame.model.menu.MainMenu;
import com.chickengame.model.levelmenu.ButtonLevel;
import com.chickengame.model.levelmenu.LevelMenu;
import com.chickengame.state.LevelState;
import com.chickengame.state.MenuState;

public class LevelMenuController extends Controller<Menu>
{
    public LevelMenuController(Menu location)
    {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        LevelMenu location = (LevelMenu)getLocation();
        switch(action)
        {
            case UP, RIGHT -> location.selectNext();
            case DOWN -> location.selectBack();
            case LEFT -> location.selectPrev();
            case SELECT ->
            {
                switch (location.getCurrentButton().getType())
                {
                    case Button.Type.Back->game.setState(new MenuState(new MainMenu()));
                    case Button.Type.Level ->runLevel(game,((ButtonLevel)location.getCurrentButton()).getLevel());
                }
            }
        }
    }

    private void runLevel(Game game, int level)
    {
        game.setState(new LevelState(new LevelMapBuilder().createLevelMap("/maps/",new MapBuilder(), game.getChickenSkin(), level)));
    }
}
