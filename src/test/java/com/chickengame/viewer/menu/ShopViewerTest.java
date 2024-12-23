package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.chickengame.viewer.menus.ButtonViewer;
import com.chickengame.viewer.menus.ShopViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class ShopViewerTest {
    private GUI gui;
    private ButtonViewer buttonViewer;
    private ElementViewer elementViewer;
    private ShopViewer shopViewer;
    private Chicken element1;
    private Chicken element2;
    private Chicken element3;
    private Element background;
    private ShopMenu shopmenu;
    private ButtonViewerFactory buttonViewerFactory;
    private ElementViewerFactory elementViewerFactory;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.elementViewer = Mockito.mock(ElementViewer.class);
        this.element1 = Mockito.mock(Chicken.class);
        this.element2 = Mockito.mock(Chicken.class);
        this.element3 = Mockito.mock(Chicken.class);
        this.background = Mockito.mock(Element.class);
        this.shopmenu = Mockito.mock(ShopMenu.class);
        this.buttonViewer = Mockito.mock(ButtonViewer.class);
        this.buttonViewerFactory = Mockito.mock(ButtonViewerFactory.class);
        this.elementViewerFactory=Mockito.mock(ElementViewerFactory.class);

        Mockito.when(shopmenu.getBackground()).thenReturn("shopBackground");
        Mockito.when(element1.getName()).thenReturn("chicken1");
        Mockito.when(element2.getName()).thenReturn("chicken2");
        Mockito.when(element3.getName()).thenReturn("chicken3");
        Mockito.when(elementViewerFactory.getShopChickenViewer(any())).thenReturn(elementViewer);
        Mockito.when(buttonViewerFactory.getViewer(any())).thenReturn(buttonViewer);
        Mockito.when(background.getName()).thenReturn("background");
        Mockito.when(shopmenu.getMiddleChicken()).thenReturn(element2);
        Mockito.when(shopmenu.getLeftChicken()).thenReturn(element1);
        Mockito.when(shopmenu.getRightChicken()).thenReturn(element3);

        this.shopViewer = new ShopViewer(shopmenu , buttonViewerFactory, elementViewerFactory);
    }

    @Test
    public void drawElements() throws IOException {

        shopViewer.draw(gui);

        Mockito.verify(elementViewerFactory, Mockito.times(3)).getShopChickenViewer(any());

        Mockito.verify(element1, Mockito.times(1)).getName();
        Mockito.verify(element2, Mockito.times(1)).getName();
        Mockito.verify(element3, Mockito.times(1)).getName();

        Mockito.verify(shopmenu,Mockito.times(2)).getMiddleChicken();
        Mockito.verify(shopmenu,Mockito.times(2)).getRightChicken();
        Mockito.verify(shopmenu,Mockito.times(2)).getLeftChicken();

        Mockito.verify(elementViewer, Mockito.times(3)).draw(any(GUI.class),any(Element.class));
        Mockito.verify(gui, Mockito.times(1)).drawImage(any(),any());
    }
}
