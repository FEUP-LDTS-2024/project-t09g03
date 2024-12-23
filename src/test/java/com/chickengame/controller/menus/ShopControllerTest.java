package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.model.menus.buttons.Button;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShopControllerTest {
    private Game game;
    private GUI gui;
    private ShopController shopController;
    private ShopMenu shopMenu;


    @BeforeEach
    @BeforeProperty
    public void helper() {
        this.shopMenu = Mockito.mock(ShopMenu.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.shopController = new ShopController(shopMenu);
    }

    @Test
    void testConstructor() {
        assertNotNull(shopController);
        assert shopController.getLocation() == shopMenu;
    }

    @Property
    public void downTest(@ForAll @IntRange(min = 1, max = 10) int repetitions) {
        Mockito.reset(shopMenu);
        for (int i = 1; i < repetitions; i++) {
            this.shopController.step(game, gui, GUI.Action.DOWN);
            Mockito.verify(shopMenu, Mockito.times(i)).selectButton(0);
        }
    }

}
