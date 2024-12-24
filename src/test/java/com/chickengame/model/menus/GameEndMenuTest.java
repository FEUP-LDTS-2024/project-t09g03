package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameEndMenuTest
{
    @Test
    public void testConstructor()
    {
        GameEndMenu gameEndMenuWin = new GameEndMenu("win");
        GameEndMenu gameEndMenuGameOver = new GameEndMenu("gameOver");

        Assertions.assertEquals(gameEndMenuWin.getBackground(), "winBackground");

        Assertions.assertEquals(gameEndMenuWin.getButtons().getFirst().getPosition().getX(), 290);
        Assertions.assertEquals(gameEndMenuWin.getButtons().getFirst().getPosition().getY(), 290);

        Assertions.assertTrue(gameEndMenuWin.getButtons().getFirst().isSelected());
        Assertions.assertEquals(gameEndMenuWin.getButtons().getFirst().getType(),Button.Type.Back);

        Assertions.assertEquals(gameEndMenuGameOver.getBackground(), "gameOverBackground");

        Assertions.assertEquals(gameEndMenuGameOver.getButtons().getFirst().getPosition().getX(), 290);
        Assertions.assertEquals(gameEndMenuGameOver.getButtons().getFirst().getPosition().getY(), 290);

        Assertions.assertTrue(gameEndMenuGameOver.getButtons().getFirst().isSelected());
        Assertions.assertEquals(gameEndMenuGameOver.getButtons().getFirst().getType(),Button.Type.Back);
    }
}
