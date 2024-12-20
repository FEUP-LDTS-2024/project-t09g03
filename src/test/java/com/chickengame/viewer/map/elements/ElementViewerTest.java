package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class ElementViewerTest {
    private ImageLoader imgLoader;
    private GUI gui;
    private Element element;
    private BasicTextImage image;
    private Position position;

    @BeforeEach
    void helper()
    {
        this.imgLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.image = Mockito.mock(BasicTextImage.class);
        this.element = Mockito.mock(Element.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(element.getPosition()).thenReturn(position);
        Mockito.when(imgLoader.getImage(any())).thenReturn(this.image);
    }

    @Test
    void draw()
    {
        ElementViewer elementViewer = new ElementViewer(imgLoader, "background");
        elementViewer.draw(gui, element);

        Mockito.verify(gui, Mockito.times(1)).drawImage(element.getPosition(), this.image);
    }
}
