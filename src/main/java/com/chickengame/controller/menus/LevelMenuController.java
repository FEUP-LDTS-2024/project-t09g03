package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.controller.Controller;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMapBuilder;
import com.chickengame.model.game.map.MapBuilder;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.model.menus.LevelMenu;
import com.chickengame.state.game.LevelState;
import com.chickengame.state.menus.MainMenuState;

public class LevelMenuController extends Controller<LevelMenu>
{
    public LevelMenuController(LevelMenu location)
    {
        super(location);
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action)
    {
        switch(action)
        {
            case UP, RIGHT -> getLocation().selectNext();
            case DOWN -> getLocation().selectBack();
            case LEFT -> getLocation().selectPrev();
            case SELECT ->
            {
                switch (getLocation().getCurrentButton().getType())
                {
                    case Button.Type.Back->game.setState(new MainMenuState(new MainMenu()));
                    case Button.Type.Level ->runLevel(game,((ButtonLevel)getLocation().getCurrentButton()).getLevel());
                }
            }
        }
    }

    private void runLevel(Game game, int level)
    {
        game.setState(new LevelState(new LevelMapBuilder().createLevelMap("maps/",new MapBuilder(), game.getChickenSkin(), level)));
    }
}
