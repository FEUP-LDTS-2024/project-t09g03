package com.chickengame.model.menus;

import com.chickengame.model.menus.buttons.Button;
import org.junit.jupiter.api.Test;

public class HelpMenuTest {
    @Test
    public void testConstructor()
    {
        HelpMenu helpMenu = new HelpMenu();

        assert helpMenu.getBackground().equals("helpBackground");
        assert helpMenu.getButtons().getFirst().getPosition().getX() == 500;
        assert helpMenu.getButtons().getFirst().getPosition().getY() == 10;
        assert helpMenu.getButtons().getFirst().isSelected();
        assert helpMenu.getButtons().getFirst().getType() == Button.Type.Back;

    }
}
