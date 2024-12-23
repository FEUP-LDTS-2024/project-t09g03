package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.menus.ButtonViewer;
import com.chickengame.viewer.menus.MenuViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MenuViewerTest {
    private MenuViewer menuViewer;
    private ButtonViewerFactory buttonViewerFactory;
    private GUI gui;
    private Menu menu;
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
        this.menu = Mockito.mock(MainMenu.class);
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

        Mockito.when(buttonViewerFactory.getBackground("background")).thenReturn(basicTextImage);

        Mockito.when(button1.getType()).thenReturn(Button.Type.Back);
        Mockito.when(button2.getType()).thenReturn(Button.Type.Previous);
        Mockito.when(button3.getType()).thenReturn(Button.Type.Next);
        Mockito.when(button4.getType()).thenReturn(Button.Type.Level);

        Mockito.when(button4.getLevel()).thenReturn(2);

        Mockito.when(buttonViewerFactory.getViewer("Back")).thenReturn(buttonViewer1);
        Mockito.when(buttonViewerFactory.getViewer("Previous")).thenReturn(buttonViewer2);
        Mockito.when(buttonViewerFactory.getViewer("Next")).thenReturn(buttonViewer3);
        Mockito.when(buttonViewerFactory.getViewer("Level2")).thenReturn(buttonViewer4);

        Mockito.when(menu.getButtons()).thenReturn(buttons);

        this.menuViewer = new MenuViewer(menu, buttonViewerFactory);
    }

    @Test
    public void drawElements() throws IOException {
        menuViewer.draw(gui);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Back");
        Mockito.verify(buttonViewer1, Mockito.times(1)).draw(gui,button1);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Previous");
        Mockito.verify(buttonViewer2, Mockito.times(1)).draw(gui,button2);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Next");
        Mockito.verify(buttonViewer3, Mockito.times(1)).draw(gui,button3);

        Mockito.verify(buttonViewerFactory, Mockito.times(1)).getViewer("Level2");
        Mockito.verify(buttonViewer4, Mockito.times(1)).draw(gui,button4);
    }
}
