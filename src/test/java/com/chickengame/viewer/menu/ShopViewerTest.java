package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.chickengame.viewer.menus.ButtonViewer;
import com.chickengame.viewer.menus.ShopViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class ShopViewerTest
{
    private GUI gui;
    private ElementViewer elementViewer;
    private ShopViewer shopViewer;
    private Chicken chicken1;
    private Chicken chicken2;
    private Chicken chicken3;
    private ShopMenu shopMenu;
    private ButtonViewerFactory buttonViewerFactory;
    private ElementViewerFactory elementViewerFactory;
    private ElementViewer elementViewer1;
    private ElementViewer elementViewer2;
    private ElementViewer elementViewer3;
    private List<Button> buttons;
    private Button button1;
    private Button button2;
    private Button button3;
    private ButtonLevel button4;
    private ButtonViewer buttonViewer1;
    private ButtonViewer buttonViewer2;
    private ButtonViewer buttonViewer3;
    private ButtonViewer buttonViewer4;
    private BasicTextImage basicTextImage;

    @BeforeEach
    public void helper()
    {
        this.shopMenu = Mockito.mock(ShopMenu.class);
        this.basicTextImage = Mockito.mock(BasicTextImage.class);
        this.buttonViewerFactory = Mockito.mock(ButtonViewerFactory.class);
        this.gui = Mockito.mock(GUI.class);
        this.buttons = new ArrayList<>();

        this.button1 = Mockito.mock(Button.class);
        this.button2 = Mockito.mock(Button.class);
        this.button3 = Mockito.mock(Button.class);
        this.button4 = Mockito.mock(ButtonLevel.class);

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);

        this.buttonViewer1 = Mockito.mock(ButtonViewer.class);
        this.buttonViewer2 = Mockito.mock(ButtonViewer.class);
        this.buttonViewer3 = Mockito.mock(ButtonViewer.class);
        this.buttonViewer4 = Mockito.mock(ButtonViewer.class);

        this.gui = Mockito.mock(GUI.class);
        this.chicken1 = Mockito.mock(Chicken.class);
        this.chicken2 = Mockito.mock(Chicken.class);
        this.chicken3 = Mockito.mock(Chicken.class);
        this.elementViewer1 = Mockito.mock(ElementViewer.class);
        this.elementViewer2 = Mockito.mock(ElementViewer.class);
        this.elementViewer3 = Mockito.mock(ElementViewer.class);
        this.shopMenu = Mockito.mock(ShopMenu.class);
        this.buttonViewerFactory = Mockito.mock(ButtonViewerFactory.class);
        this.elementViewerFactory=Mockito.mock(ElementViewerFactory.class);

        Mockito.when(shopMenu.getBackground()).thenReturn("shopBackground");
        Mockito.when(buttonViewerFactory.getBackground("shopBackground")).thenReturn(basicTextImage);

        Mockito.when(button1.getType()).thenReturn(Button.Type.Back);
        Mockito.when(button2.getType()).thenReturn(Button.Type.Previous);
        Mockito.when(button3.getType()).thenReturn(Button.Type.Next);
        Mockito.when(button4.getType()).thenReturn(Button.Type.Level);

        Mockito.when(button4.getLevel()).thenReturn(2);

        Mockito.when(buttonViewerFactory.getViewer("Back")).thenReturn(buttonViewer1);
        Mockito.when(buttonViewerFactory.getViewer("Previous")).thenReturn(buttonViewer2);
        Mockito.when(buttonViewerFactory.getViewer("Next")).thenReturn(buttonViewer3);
        Mockito.when(buttonViewerFactory.getViewer("Level2")).thenReturn(buttonViewer4);

        Mockito.when(shopMenu.getButtons()).thenReturn(buttons);

        Mockito.when(chicken1.getName()).thenReturn("chicken1");
        Mockito.when(chicken2.getName()).thenReturn("chicken2");
        Mockito.when(chicken3.getName()).thenReturn("chicken3");

        Mockito.when(elementViewerFactory.getShopChickenViewer("chicken1")).thenReturn(elementViewer1);
        Mockito.when(elementViewerFactory.getShopChickenViewer("chicken2")).thenReturn(elementViewer2);
        Mockito.when(elementViewerFactory.getShopChickenViewer("chicken3")).thenReturn(elementViewer3);

        Mockito.when(shopMenu.getMiddleChicken()).thenReturn(chicken1);
        Mockito.when(shopMenu.getLeftChicken()).thenReturn(chicken2);
        Mockito.when(shopMenu.getRightChicken()).thenReturn(chicken3);

        this.shopViewer = new ShopViewer(shopMenu , buttonViewerFactory, elementViewerFactory);
    }

    @Test
    public void drawElements() throws IOException {

        shopViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage(any(Position.class),any(BasicTextImage.class));

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Back");
        Mockito.verify(buttonViewer1, Mockito.times(1)).draw(gui,button1);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Previous");
        Mockito.verify(buttonViewer2, Mockito.times(1)).draw(gui,button2);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Next");
        Mockito.verify(buttonViewer3, Mockito.times(1)).draw(gui,button3);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Level2");
        Mockito.verify(buttonViewer4, Mockito.times(1)).draw(gui,button4);

        Mockito.verify(elementViewerFactory,Mockito.times(1)).getShopChickenViewer("chicken1");
        Mockito.verify(elementViewer1, Mockito.times(1)).draw(gui, chicken1);

        Mockito.verify(elementViewerFactory,Mockito.times(1)).getShopChickenViewer("chicken2");
        Mockito.verify(elementViewer2, Mockito.times(1)).draw(gui, chicken2);

        Mockito.verify(elementViewerFactory,Mockito.times(1)).getShopChickenViewer("chicken3");
        Mockito.verify(elementViewer3, Mockito.times(1)).draw(gui, chicken3);

    }
}
