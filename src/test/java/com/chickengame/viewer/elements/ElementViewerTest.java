package com.chickengame.viewer.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;

public class ElementViewerTest
{
    private ImageLoader imgLoader;
    private GUI gui;
    private Element element;
    private BasicTextImage image;
    private Position position;

    @BeforeProperty
    public void helper()
    {
        this.imgLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.image = Mockito.mock(BasicTextImage.class);
        this.element = Mockito.mock(Element.class);
        this.position = Mockito.mock(Position.class);

    }

    @Property
    void draw(@ForAll String path)
    {
        Mockito.when(imgLoader.getImage(path)).thenReturn(image);
        Mockito.when(element.getPosition()).thenReturn(position);

        InOrder inOrder = inOrder(gui,imgLoader);

        ElementViewer elementViewer = new ElementViewer(imgLoader, path);

        inOrder.verify(imgLoader,calls(1)).getImage(path);

        elementViewer.draw(gui, element);

        inOrder.verify(gui, Mockito.calls(1)).drawImage(position, this.image);
    }
}
