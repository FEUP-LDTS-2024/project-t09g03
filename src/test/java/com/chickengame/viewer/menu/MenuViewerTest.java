package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.menus.MainMenu;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.elements.ElementViewer;
import com.chickengame.viewer.menus.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.inOrder;

public class MenuViewerTest {
    private MenuViewer menuViewer;
    private GUI gui;
    private ElementViewer backgroundViewer;
    private MainMenu mainMenu;
    private ButtonViewerFactory buttonViewerFactory;
    private List<Button> buttons;
    private Element background;
    private Button button;
    private InOrder inOrder;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.backgroundViewer = Mockito.mock(ElementViewer.class);
        this.mainMenu = Mockito.mock(MainMenu.class);
        this.buttonViewerFactory = Mockito.mock(ButtonViewerFactory.class);
        this.buttons = new ArrayList<>();
        this.background = Mockito.mock(Element.class);
        this.button = Mockito.mock(Button.class);
        this.inOrder = inOrder(backgroundViewer);

        buttons.add(button);
        Mockito.when(mainMenu.getBackground()).thenReturn(background);
        Mockito.when(button.getName()).thenReturn("name");
        Mockito.when(background.getName()).thenReturn("name");
        Mockito.when(mainMenu.getButtons()).thenReturn(buttons);
        Mockito.when(buttonViewerFactory.getViewer(anyString())).thenReturn(backgroundViewer);

        this.menuViewer = new MenuViewer(mainMenu, buttonViewerFactory);
    }

    @Test
    public void drawElements() throws IOException {
        menuViewer.draw(gui);

        Mockito.verify(buttonViewerFactory, Mockito.times(1 + buttons.size())).getViewer(button.getName());
        inOrder.verify(backgroundViewer, Mockito.calls(1 + buttons.size() )).draw(any(GUI.class),any(Element.class));
    }
}
