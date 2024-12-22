package com.chickengame.viewer.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.input.KeyType;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;

public class ElementViewerTest {
    private ImageLoader imgLoader;
    private GUI gui;
    private Element element;
    private BasicTextImage image;
    private Position position;
    private List<String> names;

    @BeforeEach
    @BeforeProperty
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

    @Provide
    Arbitrary<String> stringTypeArbitrary() {
        return Arbitraries.of("background", "chocolatePlatform", "cookie", "finishLine", "helpBackground", "mainBackground", "platform", "shopBackground");
    }

    @Property
    void draw(@ForAll("stringTypeArbitrary") String name)
    {
        InOrder inOrder = inOrder(gui);
        ElementViewer elementViewer = new ElementViewer(imgLoader, name);
        elementViewer.draw(gui, element);

        inOrder.verify(gui, Mockito.calls(1)).drawImage(element.getPosition(), this.image);
    }
}
