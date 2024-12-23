package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.Test;

public class GameEndMenuTest {
    @Test
    public void testConstructor()
    {
        GameEndMenu gameEndMenuWin = new GameEndMenu("win");
        GameEndMenu gameEndMenuGO = new GameEndMenu("gameOver");

        assert gameEndMenuWin.getBackground().equals("winBackground");
        assert gameEndMenuWin.getButtons().getFirst().getPosition().getX() == 290;
        assert gameEndMenuWin.getButtons().getFirst().getPosition().getY() == 290;
        assert gameEndMenuWin.getButtons().getFirst().getType() == Button.Type.Back;

        assert gameEndMenuGO.getBackground().equals("gameOverBackground");
        assert gameEndMenuGO.getButtons().getFirst().getPosition().getX() == 290;
        assert gameEndMenuGO.getButtons().getFirst().getPosition().getY() == 290;
        assert gameEndMenuGO.getButtons().getFirst().getType() == Button.Type.Back;
    }
}
