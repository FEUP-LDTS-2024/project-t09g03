package com.chickengame.state.menus;

import com.chickengame.Game;
import com.chickengame.controller.menus.ShopController;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.viewer.menus.ShopViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ShopStateTest
{
    private ShopState shopState;
    private ShopMenu shopMenu;
    private ShopController shopController;
    private ShopViewer shopViewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.shopController = Mockito.mock(ShopController.class);
        this.shopViewer = Mockito.mock(ShopViewer.class);
        this.shopMenu = Mockito.mock(ShopMenu.class);
        this.game = Mockito.mock(Game.class);

        Mockito.when(shopMenu.getBackground()).thenReturn("background");
    }

    @Test
    public void shopState() throws IOException
    {
        this.shopState = new ShopState(shopMenu)
        {
            @Override
            public ShopViewer getStateViewer()
            {
                return shopViewer;
            }
            @Override
            public ShopController getStateController()
            {
                return shopController;
            }
        };

        shopState.step(game, GUI.Action.NONE,gui);
        Mockito.verify(shopController, Mockito.times(1)).step(game, gui,GUI.Action.NONE);
        Mockito.verify(shopViewer, Mockito.times(1)).draw(gui);
    }

    @Test
    public void shopStateCreate()
    {
        ShopState shopState = new ShopState(shopMenu);

        Assertions.assertNotNull(shopState.getStateController());
        Assertions.assertNotNull(shopState.getStateViewer());
    }
}
