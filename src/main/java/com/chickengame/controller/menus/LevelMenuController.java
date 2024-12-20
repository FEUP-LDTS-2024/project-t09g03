package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.game.map.LevelMapBuilder;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.state.LevelState;
import com.chickengame.state.MainMenuState;

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
                    case Button.Type.Back->game.setState(new MainMenuState(new MainMenu()));
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
