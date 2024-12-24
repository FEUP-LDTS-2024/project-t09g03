package com.chickengame.controller.menus;

import com.chickengame.Game;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.state.menus.MainMenuState;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

public class ShopControllerTest
{
    private Game game;
    private GUI gui;
    private ShopController shopController;
    private ShopMenu shopMenu;
    private Button button;

    @BeforeEach
    @BeforeProperty
    public void helper()
    {
        this.shopMenu = Mockito.mock(ShopMenu.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.button = Mockito.mock(Button.class);

        Mockito.when(shopMenu.getSelected()).thenReturn(button);

        this.shopController = new ShopController(shopMenu);
    }

    @Test
    void testConstructor()
    {
        assertNotNull(shopController);
        assert shopController.getLocation() == shopMenu;
    }

    @Property
    public void leftTest(@ForAll @IntRange(min = 1, max = 10) int repetitions)
    {
        Mockito.reset(shopMenu);
        for (int i = 1; i < repetitions; i++) {
            this.shopController.step(game, gui, GUI.Action.LEFT);
            Mockito.verify(shopMenu, Mockito.times(i)).previousButton();
        }
    }

    @Property
    public void rightTest(@ForAll @IntRange(min = 1, max = 10) int repetitions)
    {
        Mockito.reset(shopMenu);
        for (int i = 1; i < repetitions; i++) {
            this.shopController.step(game, gui, GUI.Action.RIGHT);
            Mockito.verify(shopMenu, Mockito.times(i)).nextButton();
        }
    }

    @Property
    public void downTest(@ForAll @IntRange(min = 1, max = 10) int repetitions)
    {
        Mockito.reset(shopMenu);
        for (int i = 1; i < repetitions; i++) {
            this.shopController.step(game, gui, GUI.Action.DOWN);
            Mockito.verify(shopMenu, Mockito.times(i)).selectButton(0);
        }
    }

    @Test
    public void selectBack()
    {
        Mockito.when(button.getType()).thenReturn(Button.Type.Back);
        shopController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(game, Mockito.times(1)).setChickenSkin(0);
        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }

    @Test
    public void selectNext()
    {
        Mockito.when(button.getType()).thenReturn(Button.Type.Next);
        shopController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(shopMenu, Mockito.times(1)).getNextSkin();
    }

    @Test
    public void selectPrevious()
    {
        Mockito.when(button.getType()).thenReturn(Button.Type.Previous);
        shopController.step(game, gui, GUI.Action.SELECT);

        Mockito.verify(shopMenu, Mockito.times(1)).getPreviousSkin();
    }
}
