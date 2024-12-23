package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameEndMenuTest {
    @Test
    public void testConstructor()
    {
        GameEndMenu gameEndMenuWin = new GameEndMenu("win");
        GameEndMenu gameEndMenuGO = new GameEndMenu("gameOver");

        Assertions.assertEquals(gameEndMenuWin.getBackground(), "winBackground");
        Assertions.assertEquals(gameEndMenuWin.getButtons().getFirst().getPosition().getX(), 290);
        Assertions.assertEquals(gameEndMenuWin.getButtons().getFirst().getPosition().getY(), 290);
        Assertions.assertTrue(gameEndMenuWin.getButtons().getFirst().isSelected());
        Assertions.assertEquals(gameEndMenuWin.getButtons().getFirst().getType(),Button.Type.Back);

        Assertions.assertEquals(gameEndMenuGO.getBackground(), "gameOverBackground");
        Assertions.assertEquals(gameEndMenuGO.getButtons().getFirst().getPosition().getX(), 290);
        Assertions.assertEquals(gameEndMenuGO.getButtons().getFirst().getPosition().getY(), 290);
        Assertions.assertTrue(gameEndMenuGO.getButtons().getFirst().isSelected());
        Assertions.assertEquals(gameEndMenuGO.getButtons().getFirst().getType(),Button.Type.Back);

    }
}
